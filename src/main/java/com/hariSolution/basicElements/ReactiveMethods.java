package com.hariSolution.basicElements;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReactiveMethods {

    private Flux<String>doMap(){
       Flux<String> fluxData= Flux.just("java","html","css","react");
       return fluxData.map(data->data.toUpperCase(Locale.ROOT));
    }

    private Flux<String>doFlatMap(){
        Flux<String> fluxData= Flux.just("java","html","css","react");

        // fluxData.flatMap(data-> Mono.just(data.toUpperCase()));

        return fluxData.flatMap(data->Flux.just(data.toUpperCase()));
    }


    private Flux<String>doBasicSkip(){
        Flux<String> fluxData= Flux.just("java","html","css","react")
                /*.delayElements(Duration.ofSeconds(1))*/;

       // return fluxData.skip(2); //while give 2 numbers the first number 2 of elements wil gone

      //  return fluxData.skip(Duration.ofSeconds(3)); if we want to skip the particular period of the duration, we have to specify the that particular period into the method

        return  fluxData.skipLast(2); //while give 2 numbers the last number 2 of elements wil gone

    }

    private Flux<Integer>doComplexSkip(){
        Flux<Integer> fluxData= Flux.range(1,30);


       // return  fluxData.skipWhile(element->element <10); //based on condition will stop

        return  fluxData.skipUntil(element->element ==12); //until true will execute

    }

    private Flux<Integer> doConcat(){
        Flux<Integer>flexData1= Flux.range(1,30);
        Flux<Integer>flexData2= Flux.range(31,4);
        return Flux.concat(flexData1,flexData2); //concat = flexData 1 =1 to 30(count=4) + flexData 1 =31 to 34(count=4)
    }

    private Flux<Integer> doMarge(){
        Flux<Integer>flexData1= Flux.range(1,30) /*.delayElements(Duration.ofMillis(500))*/;
        Flux<Integer>flexData2= Flux.range(31,10)/*.delayElements(Duration.ofMillis(500))*/;
        return Flux.merge(flexData1,flexData2);
    }

    private Flux<Tuple2<Integer,Integer>> doZip(){
        Flux<Integer>flexData1= Flux.range(1,30) /*.delayElements(Duration.ofMillis(500))*/;
        Flux<Integer>flexData2= Flux.range(31,30)/*.delayElements(Duration.ofMillis(500))*/;


        return Flux.zip(flexData1,flexData2);
    }

    private Flux<Tuple3<Integer,Integer,Integer>> doComplexZip(){
        Flux<Integer>flexData1= Flux.range(1,30) /*.delayElements(Duration.ofMillis(500))*/;
        Flux<Integer>flexData2= Flux.range(31,30)/*.delayElements(Duration.ofMillis(500))*/;
        Flux<Integer>flexData3= Flux.range(41,30)/*.delayElements(Duration.ofMillis(500))*/;


        return Flux.zip(flexData1,flexData2,flexData3);
    }

    private Mono<List<Integer>>doCollectList(){
        Flux<Integer> flux=Flux.range(1,10);
        return flux.collectList();
    }

    private Flux<List<Integer>> doBuffer(){
        Flux<Integer> flux=Flux.range(1,10).delayElements(Duration.ofMillis(1000));
        //return flux.buffer(5);
        return flux.buffer(Duration.ofSeconds(3));
    }


    private Mono<Map<Integer,Integer>> doCollectMap(){
        Flux<Integer> flux=Flux.range(1,10);
        return flux.collectMap(integer -> integer,integer -> integer*integer);

    }


    private Flux<Integer>textDoOnEach(){
        Flux<Integer> flux=Flux.range(1,10);

        return flux.doOnEach(signal->{
            if(signal.getType() == SignalType.ON_COMPLETE){
                System.out.println(" activities has been done");
            }
        });
    }


    private Flux<Integer> doOnComplete(){
        Flux<Integer> flux=Flux.range(1,10);

        return flux.doOnComplete(()->System.out.println("this activities has been completed"));
    }

    private Flux<Integer> doOnNext(){
        Flux<Integer> flux=Flux.range(1,10);

        return flux.doOnNext(data->System.out.println("next completed"));
    }

    private Flux<Integer> doFinally(){
        Flux<Integer> flux=Flux.range(1,10);

        return flux.doFinally(data->System.out.println("next completed"));
    }


    private Flux<Integer> doCancel(){
        Flux<Integer> flux=Flux.range(1,50).delayElements(Duration.ofSeconds(1));

        return flux.doOnCancel(()->System.out.println("CANCELED"));
    }

    private Flux<Integer> errorHandling(){
        Flux<Integer> flux=Flux.range(1,50)
                .map(integer -> {
                    if(integer==5){
                        throw new RuntimeException();

                    }
                    return integer;
                });

        return flux.onErrorContinue((throwable, o) -> System.out.println("don't wory about"+o));
    }


    private Flux<Integer> errorHandling2(){
        Flux<Integer> flux=Flux.range(1,30)
                .map(integer -> {
                    if(integer ==5){
                        throw new RuntimeException();
                    }
                    return integer;
                });
        return  flux.onErrorReturn(-1);
    }

    private Flux<Integer> errorHandling3(){
        Flux<Integer> flux=Flux.range(1,30)
                .map(integer -> {
                    if(integer ==5){
                        throw new RuntimeException();
                    }
                    return integer;
                });
        return  flux.onErrorReturn(RuntimeException.class,-1).onErrorReturn(ArrayIndexOutOfBoundsException.class,-2);
    }

    private Flux<Integer> errorHandling4(){
        Flux<Integer> flux=Flux.range(1,30)
                .map(integer -> {
                    if(integer ==5){
                        throw new RuntimeException();
                    }
                    return integer;
                });  //when error happened, we can give an alternative solution for that
        Flux<Integer> flux2=Flux.range(6,25);
        return  flux.onErrorResume(exception->flux2);
    }


    private Flux<Integer> errorHandling5(){
        Flux<Integer> flux=Flux.range(1,30)
                .map(integer -> {
                    if(integer ==5){
                        throw new RuntimeException();
                    }
                    return integer;
                });  //when error happened, we can give an alternative solution for that
        Flux<Integer> flux2=Flux.range(6,25);
        return  flux.onErrorMap(exception->new UnsupportedOperationException());
    }

    public static void main(String[] args) throws InterruptedException {
        ReactiveMethods reactiveMethods=new ReactiveMethods();
        //reactiveMethods.doMap().subscribe(System.out::println);

       // reactiveMethods.doFlatMap().subscribe(System.out::println);

       // reactiveMethods.doBasicSkip().subscribe(System.out::println);

        //reactiveMethods.doComplexSkip().subscribe(System.out::println);

       // reactiveMethods.doConcat().subscribe(System.out::println);
       // reactiveMethods.doMarge().subscribe(System.out::println);

      //  reactiveMethods.doZip().subscribe(System.out::println);

     //  reactiveMethods.doComplexZip().subscribe(System.out::println);

      /* List<Integer> outcome= reactiveMethods.doCollectList().block(); //in this case, we have to convert to from reactive programming to normal programming
        System.out.println(outcome);*/

     //   reactiveMethods.doBuffer().subscribe(System.out::println);

     //   reactiveMethods.doCollectMap().subscribe(System.out::println);


     //   reactiveMethods.doOnComplete().subscribe(System.out::println);

      //  reactiveMethods.doFinally().subscribe(System.out::println);


      /* Disposable disposable= reactiveMethods.doCancel().subscribe(System.out::println);
       disposable.dispose();*/

      //  reactiveMethods.errorHandling3().subscribe(System.out::println);

        reactiveMethods.doBuffer().subscribe(System.out::println);


      // Thread.sleep(3_500);

    }
}
