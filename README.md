# OOP-01
exercise in oop in java 01.

# Authors
[Talor Langnas](https://github.com/TalorLangnas)  
[Elroei Avraham](https://github.com/elroei1avraham).


# About the project
we were ask to do this project the design patterns of a kind observer.
the project is here [oop-01](https://github.com/elroei1avraham/OOP-01].


# About observer
observer ia a design patterns that was a class/interface and the other class know immediately if they have a change.
in our exercise we have the class UndoableStringBuilder that we wrote in the previous exercise and now we have a class groupAdmin that have a members and we send them information about the UndoableStringBuilder class.
the members get an information after they register to the list of members and immediately all the changes the UndoableStringBuilder passes.


# Which class we have and what they have into
UndoableStringBuilder - we wrote in the prev exercise all the function.
 - reverse - get out string in reverse.
 - append - append string in the end of our string.
 - insert - insert string in the index we get in our string.  
 - delete - delete string frome start index to end index (we get the start index and end index) in our string.
 - replace - replace string frome start index to end index (we get the start index and end index) in our string int the other string that we get.
 - undo - we get the string without the last change.
 - toString - get out string.
 
we get 2 interface is ready "Sender", "Member" and the class "GroupAdmin" implements Sender and the class "ConcreteMember" implements Member

GroupAdmin:
have 2 variable
1. groupAdmin in kind of the class UndoableStringBuilder.
2. Members in kind of HashSet<Member> that have all the members that registered to this UndoableStringBuilder.

the class have function: 
 - getSize - get the number of registered members to this UndoableStringBuilder.
 - toString - get the UndoableStringBuilder string.
 - getState - get the UndoableStringBuilder string and all the members that registered to this UndoableStringBuilder in long string.
 - register - register new member to this UndoableStringBuilder.
 - unregister - remove member from the HashSet(we get the members that we want to remove.
 - insert - insert string in the index we get in our string and tell all the members that the UndoableStringBuilder has changed.
 - append - append string in the end of our string and tell all the members that the UndoableStringBuilder has changed.
  - delete - delete string frome start index to end index (we get the start index and end index) in our string and tell all the members that the UndoableStringBuilder has changed.
 - undo - we get the string without the last change and tell all the members that the UndoableStringBuilder has changed.
 
 
