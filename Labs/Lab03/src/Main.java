public class Main {

    public static void main (String args[]) {
        Animal ref;

        Cow Bossy = new Cow("Bossy");
        Dog Rover = new Dog("Rover");
        Snake Ernie = new Snake("Ernie");
        WorkingDogs Workingdogs = new WorkingDogs("Wdog");

        ref = Bossy;
 //       ref.speak();

        Animal newArr[] = new Animal[4];

        newArr[0] = Bossy;
        newArr[1] = Rover;
        newArr[2] = Ernie;
        newArr[3] = Workingdogs;

//        for (Animal x : newArr) {
//            x.speak();
//            x.toString();

 //       }

        Animal var1 = new Dog("dog" );
        Animal var2 = new Cow("cow" );
        WorkingDogs var3 = new WorkingDogs("workdog" );
        Dog var4 = new WorkingDogs("workdog2" );
        Cow var7 = new Cow("cow2");
        Snake var8 = new Snake("snake");
        Object var5 = new Cow("cow3" );
        Object var6 = new Dog("dog2" );

 //      var1.testIt1();
//       var2.testIt2();  //no test 2 method in Animal
 //      var3.testIt1();
//        var4.testIt1();
 //       var5.testIt3(); // no test methods in object class
 //       var6.testIt1();  // no test methods in object class
   //     var4.testIt2();
//        var3.testIt3();
 //       ((WorkingDogs) var4).testIt3();  // no test 3 in dog class
  //      ((Dog) var1).testIt2();
  //      ((Cow) var2).testIt2();   //cow object type cannot be changed to dog type
//        ((Animal) var8).testIt1();
      //  var7 = var2;  // animal cannot be converted to cow, but cow can be converted to animal
//        var7.testIt3();
//        ((Cow) var2).testIt3();

    }
}
