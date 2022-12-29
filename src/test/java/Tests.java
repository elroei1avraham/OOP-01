import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;




import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    /*
     Example for JvmUtilities functions prints in logger
     (dont forget to delete)
     */

    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));


        logger.info(() -> JvmUtilities.memoryStats(s1));
    }

    @Test
    public void TotalSizeTest1(){
        GroupAdmin groupAdmin = new GroupAdmin();
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
        ConcreteMember cm1 = new ConcreteMember();
        groupAdmin.register(cm1);
        System.out.println();
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
    }

    @Test
    public void TotalSizeTest2(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember cm1 = new ConcreteMember();
        ConcreteMember cm2 = new ConcreteMember();
        ConcreteMember cm3 = new ConcreteMember();
        ConcreteMember cm4 = new ConcreteMember();
        groupAdmin.register(cm1);
        groupAdmin.register(cm2);
        groupAdmin.register(cm3);
        groupAdmin.register(cm4);

        String str = ""+groupAdmin.getSize();
        assertEquals("4", str);

        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));

    }

    @Test
    public void register(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.append("HelloWorld");
        groupAdmin.register(concreteMember);
        String str = concreteMember.toString();
        assertEquals("HelloWorld", str);
        logger.info(() -> JvmUtilities.memoryStats(groupAdmin));
    }

    /**
     * Case: registered Member is trying to register again
     * Expected result: GroupAdmin will not add this Member to Members list
     * Verified by checking the changes of Members list number
     */
    @Test
    public void reRegister(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember();
        groupAdmin.register(m1);
        groupAdmin.register(m1);
        String str =""+ groupAdmin.getSize();
        assertEquals("1", str);
    }

    /**
     * Case: 3 New Members are trying to register groupAdmin
     * Expected result: 3 New Members appear in groupAdmin Members list
     * Verified by checking groupAdmin Members list size
     */
    @Test
    public void registersListMembersCheck(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember1 = new ConcreteMember();
        groupAdmin.register(concreteMember1);
        ConcreteMember concreteMember2 = new ConcreteMember();
        groupAdmin.register(concreteMember2);
        ConcreteMember concreteMember3 = new ConcreteMember();
        groupAdmin.register(concreteMember3);
        assertEquals(3, groupAdmin.getSize());
    }

    @Test
    public void unregister(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
        groupAdmin.unregister(concreteMember);

        // checks if Observer is unregister Subject and doesn't pointing him anymore
        String str = concreteMember.toString();
        assertEquals("", str);
        assertEquals(0, groupAdmin.getSize());
    }

    @Test
    public void insert(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);

        // checks if Observer is following Subject
        groupAdmin.append("HelloWorld");
        groupAdmin.insert(4,"HHH");
        String str = concreteMember.toString();
        assertEquals("HellHHHoWorld", str);
    }

    @Test
    public void delete(){
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
        groupAdmin.append("HelloWorld");

        //checks Subject
        groupAdmin.delete(2, 5);
        String str1 = groupAdmin.toString();
        assertEquals("HeWorld", str1);

        // checks if Observer is following Subject
        String str2 = concreteMember.toString();
        assertEquals("HeWorld", str2);
    }

    @Test
    public void Undo(){
        // Stack Is Empty
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
        groupAdmin.append("Hello");
        groupAdmin.append("HelloWorld");

        //checks Subject
        groupAdmin.undo();
        String str = groupAdmin.toString();
        assertEquals("Hello",str);

        // checks if Observer is following Subject
        String str1 = concreteMember.toString();
        assertEquals("Hello",str1);

    }
}
