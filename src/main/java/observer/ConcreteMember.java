package observer;

public class ConcreteMember implements Member{

    static int SerialNumber;
    private UndoableStringBuilder concreteMember;
    private int id;


    public ConcreteMember(){

        concreteMember = new UndoableStringBuilder();
        this.id = SerialNumber;
        SerialNumber++;
    }
  //  public void setConcreteMember(UndoableStringBuilder concreteMember) {
  //      this.concreteMember = concreteMember;
   // }

    public ConcreteMember(GroupAdmin Admin){
        concreteMember = new UndoableStringBuilder();
        this.id = SerialNumber;
        Admin.register(this);
        SerialNumber++;

    }
    public String toString() {
        return "" + this.id;
    }

    public String getMemberUstb(){

        return concreteMember.toString();
    }

    @Override
    public void update(UndoableStringBuilder usb) {

        concreteMember = usb;
    }
}
