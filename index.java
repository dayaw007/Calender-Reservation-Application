/*
-------------------------------------------------------- Calender Reservation Application --------------------------------------------------------------------
1. Register a user.
2. Create an event wit a set of users on a given day + slot.
3. List event for a user on a given day.
4. Suggest first time slot based on availability for a set of users for a givenn day and time range.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
The above four different features in the Calender application is invoked when an user command specific syantx related this individual features in your console.
1. add-user
2. create-event
3. show-events
4. suggest-slot
--------------------------------------------------------------------------------------------------------------------------------------------------------------
Here we are simply using a concept of OOPs with String manipulation as well as List but you use your own collections.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
This programme is done in Java you can use your own programming language as per your convenience.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
import java.util.*;
// Register a user
class RegisterUser{
    static List<String> st = new ArrayList<String>(); // Collections to store user in a database
    public static void registerUser(String input_arr){
        //System.out.println(st);
        //System.out.println(input_arr);
        if(st.isEmpty() == true){
            st.add(input_arr);
            System.out.println("success"); // user added in database
        }
        else{
            if(st.contains(input_arr) == true){
                System.out.println("failure"); // user name already available in database
            }
            else{
                st.add(input_arr);
                System.out.println("success"); // user added in database
            }
        }
    }
}
// Create an event wit a set of users on a given day + slot
class CreateEvent extends RegisterUser{
    static List<String> st1 = new ArrayList<String>(); // Collections to store event date in a database
    static List<Integer> st2 = new ArrayList<Integer>(); // Collections to store event start time in a database
    static List<Integer> st3 = new ArrayList<Integer>(); // Collections to store event duration in a database
    static List<Integer> st4 = new ArrayList<Integer>(); // Collections to store no. of user in a database
    static List<String> st5 = new ArrayList<String>(); // Collections to store user list in a database
    public static void createEvent(String input_arr[]){
        List<String> user = new ArrayList<String>(); // Dummy list to store user list
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
        System.out.println(st4);
        System.out.println(st5);
        String date;
        int start_time, sum1=0,sum2=0, net1=0, net2=0;
        int duration;
        int num, react=0;
        String userlist;
        date = input_arr[1];
        start_time = Integer.parseInt(input_arr[2]);
        duration = Integer.parseInt(input_arr[3]);
        num = Integer.parseInt(input_arr[4]);
        System.out.println(date + " " + start_time + " " + duration + " " + num);
        if(start_time >= 0 && start_time <= 1439 && duration > 0){
            if((st1.isEmpty() && st2.isEmpty() && st3.isEmpty() && st4.isEmpty() && st5.isEmpty()) == true){
                st1.add(date);
                st2.add(start_time);
                st3.add(duration);
                st4.add(num);
                for(int i=5;i<input_arr.length;i++){
                    userlist = input_arr[i];
                    if(st.contains(userlist) == true){
                        st5.add(userlist);
                        react++;
                    }
                }
                if(react == (input_arr.length - 5)){
                    System.out.println("success");
                    user.clear();
                }
            }
            else{
                for(int i=5;i<input_arr.length;i++){
                    user.add(input_arr[i]);
                }
                if(st5.containsAll(user) == false){
                    st1.add(date);
                    st2.add(start_time);
                    st3.add(duration);
                    st4.add(num);
                    if(st.containsAll(user) == true){
                        st5.addAll(user);
                        System.out.println("success");
                        user.clear();
                    }
                }
                else{
                    for(int i=5;i<input_arr.length;i++){
                        if(st5.contains(input_arr[i]) == true){
                            sum1 = start_time;
                            sum2 = start_time + duration - 1;
                            Integer arr1[] = new Integer[st2.size()];
                            arr1 = st2.toArray(arr1);
                            Integer arr2[] = new Integer[st3.size()]; 
                            arr2 = st3.toArray(arr2);
                            for(int r=0;r<st2.size();r++){
                                net1 = arr1[r] + arr2[r] - 1;
                                net2 = arr1[r];
                                int j = st2.indexOf(arr1[r]);
                                System.out.println(j);
                                if(sum1 > net1 || sum2 < net2){
                                    st1.add(date);
                                    st2.add(start_time);
                                    st3.add(duration);
                                    st4.add(num);
                                    if(st.containsAll(user) == true){
                                        st5.addAll(user);
                                        System.out.println("success");
                                        user.clear();
                                        break;
                                    }
                                }
                                if(user.contains(st5.get(j+st4.get(j-1)-1)) && user.contains(st5.get(j+st4.get(j-1))) == false){
                                    st1.add(date);
                                    st2.add(start_time);
                                    st3.add(duration);
                                    st4.add(num);
                                    if(st.containsAll(user) == true){
                                        st5.addAll(user);
                                        System.out.println("success");
                                        user.clear();
                                        break;
                                    }
                                }
                                else{
                                    System.out.println("failure");
                                    user.clear(); 
                                    break;
                                }
                            }
                        }
                        else{
                            continue;
                        }
                        net1 = 0;
                        net2 = 0;
                        sum1 = 0;
                        sum2 = 0;
                    }
                }
            }
        }
    }
}
// List event for a user on a given day
class ShowEvent extends CreateEvent{
    public static void showEvent(String input_arr[]){
        //f
        
        
        
        
        
        
        
        
    }
}
// Suggest first time slot based on availability for a set of users for a givenn day and time range
class SuggestSlot extends ShowEvent{
    public static void suggestSlot(String input_arr[]){
        //f
        
        
        
        
        
        
        
    }
}
// Test an application in your console
public class TestCalender extends SuggestSlot{
    public static void inputCheck(String input_arr[]){
        // Instead of if else you can also use switch case
        if(input_arr[0].equals("add-user")){
            registerUser(input_arr[1]); // function invoked
        }
        else if(input_arr[0].equals("create-event")){
            createEvent(input_arr); // function invoked
        }
        else if(input_arr[0].equals("show-events")){
            showEvent(input_arr); // function invoked
        }
        else if(input_arr[0].equals("suggest-slot")){
            suggestSlot(input_arr); // function invoked
        }
    }
    public static void main(String[] args){
        String user_input;
        int count, i=0;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        count++;
        while(i != count){
            i++;
            user_input = sc.nextLine();
            String input_arr[] = user_input.split("\\s"); // split based on whitespace in input string
            inputCheck(input_arr);
            System.out.println(i);
        }
    }
}
