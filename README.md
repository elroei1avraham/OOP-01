# OOP-01
Exercise in oop in java 01.

# Authors
[Talor Langnas](https://github.com/TalorLangnas)  
[Elroei Avraham](https://github.com/elroei1avraham).


# About the project
We were asked to do this project and using design patterns of a kind observer.  
The project is here:  [oop-01](https://github.com/elroei1avraham/OOP-01).


# About observer
observer in a design patterns that was a class/interface and the other objects knows immediately if they have a change.
In our exercise we have the class UndoableStringBuilder that we wrote about in the previous exercise. In this project we have a class groupAdmin that has members and we send them information about the UndoableStringBuilder class.
The members get an information after they register to the list of members and immediately all the changes the UndoableStringBuilder passes.


# Which class we have and what they have in it?
UndoableStringBuilder - We wrote in the previous exercise all the function.
 - reverse - Get out string in reverse.
 - append - Append string in the end of our string.
 - insert - Insert string in the index we get in our string.  
 - delete - Delete string frome start index to end index (we get the start index and end index) in our string.
 - replace - Replace string frome start index to end index (we get the start index and end index) in our string int the other string that we get.
 - undo - We get the string without the last change.
 - toString - Get out string.
 
We get 2 interface is ready "Sender", "Member" and the class "GroupAdmin" implements Sender and the class "ConcreteMember" implements Member

GroupAdmin:
Has 2 variables
1. groupAdmin is a kind of a class UndoableStringBuilder.
2. Members is a kind of HashSet<Member> that have all the members that registered to this UndoableStringBuilder.

The class function: 
 - getSize - Get the number of registered members to this UndoableStringBuilder.
 - toString - Get the UndoableStringBuilder string.
 - getState - Get the UndoableStringBuilder string and all the members that registered to this UndoableStringBuilder in long string.
 - register - Register new member to this UndoableStringBuilder.
 - unregister - Remove member from the HashSet(we get the members that we want to remove.
 - insert - Insert string in the index we get in our string and tell all the members that the UndoableStringBuilder has changed.
 - append - Append string in the end of our string and tell all the members that the UndoableStringBuilder has changed.
  - delete - Delete string frome start index to end index (we get the start index and end index) in our string and tell all the members that the UndoableStringBuilder has changed.
 - undo - We get the string without the last change and tell all the members that the UndoableStringBuilder has changed.
 
 # Test
 In the folder test we have a tests that we write to check our code. We try all kinds of functions from the projet and check if the output is similar to what we want it to be.
 All the tests passed and its exactly the results that we expected to receive.

