package observer;

public class Main {

    public static void main(String[] args){
       GroupAdmin admin = new GroupAdmin();

        admin.append("hello");

       // System.out.println(admin.getState());
        ConcreteMember m1 = new ConcreteMember();
        admin.register(m1);
        admin.append("World");

        ConcreteMember m2 = new ConcreteMember();
        admin.register(m2);
        System.out.println(m1.getMemberUstb());
        System.out.println(admin.getState());
        admin.register(m2);
        System.out.println(admin.getState());
        System.out.println(JvmUtilities.objectFootprint());



    }
}
