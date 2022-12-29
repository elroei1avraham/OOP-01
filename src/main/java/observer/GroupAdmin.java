package observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GroupAdmin implements Sender{

    private UndoableStringBuilder groupAdmin;
    private HashSet<Member> Members;


    public GroupAdmin(){
         groupAdmin = new UndoableStringBuilder();
         Members = new HashSet<>();
    }

    public int getSize(){

        return Members.size();
    }

    @Override
    public String toString() {
        return groupAdmin.toString();
    }

    public String getState() {
        String s = "GroupAdmin: "+ groupAdmin.toString()+" | " +"Members ID's: "+ Members.toString();
        return s;
    }

    @Override
    public void register(Member obj) {
        obj.update(this.groupAdmin);
        Members.add(obj);
    }

    @Override
    public void unregister(Member obj) {
       UndoableStringBuilder other = new UndoableStringBuilder();
        other.append(groupAdmin.toString());
        obj.update(other);
        Members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        groupAdmin.insert(offset, obj);
        for (Member member : this.Members) {
            member.update(groupAdmin);
        }
    }
    @Override
    public void append(String obj) {
        groupAdmin.append(obj);
        for (Member member : this.Members) {
            member.update(groupAdmin);
        }
    }

    @Override
    public void delete(int start, int end) {
        groupAdmin.delete(start, end);
        for (Member member : this.Members) {
            member.update(groupAdmin);
        }
    }

    @Override
    public void undo() {
        groupAdmin.undo();
        for (Member member : this.Members) {
            member.update(groupAdmin);
        }
    }
}
