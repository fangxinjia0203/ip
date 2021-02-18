import java.util.Scanner;
import java.util.ArrayList;

public class Duke {


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Duke\n" +
                " What can I do for you?");
        System.out.println("____________________________________________________________\n");
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        ArrayList<Task> Tasks = new ArrayList<Task>();
        while (!line.equals("bye")) {
            while(!line.equals("list")) {
                if (line.startsWith("done")){
                    String[] parts = line.split(" ");
                    int i=Integer.parseInt(parts[1].trim());
                    Tasks.get(i-1).markAsDone();
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Nice! I've marked this task as done:\n ");
                    System.out.println(Tasks.get(i-1).toString() + "\n");
                    System.out.println("____________________________________________________________\n");
                }
                else if (line.startsWith("todo")) {
                    try {
                        line.substring(line.indexOf(" "));
                        System.out.println("____________________________________________________________\n");
                        Todo t = new Todo(line.replace("todo ", ""));
                        Tasks.add(t);
                        System.out.println("Got it. I've added this task:\n");
                        System.out.println(t.toString() + "\n");
                        System.out.println("Now you have " + Tasks.size() + " tasks in the list.\n");
                        System.out.println("____________________________________________________________\n");
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n");
                        System.out.println("☹ OOPS!!! The description of a " + line + " cannot be empty.\n");
                        System.out.println("____________________________________________________________\n");
                    }
                }
                else if (line.startsWith("event")) {
                    try {
                        line.substring(line.indexOf(" "));
                        System.out.println("____________________________________________________________\n");
                        line = line.replace("event", "");
                        String[] parts = line.split("/at");
                        Event t = new Event(parts[0].trim(), parts[1].trim());
                        Tasks.add(t);
                        System.out.println("Got it. I've added this task:\n");
                        System.out.println(t.toString() + "\n");
                        System.out.println("Now you have " + Tasks.size() + " tasks in the list.\n");
                        System.out.println("____________________________________________________________\n");
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n");
                        System.out.println("☹ OOPS!!! The description of a " + line + " cannot be empty.\n");
                        System.out.println("____________________________________________________________\n");
                    }
                }
                else if (line.startsWith("deadline")) {
                    try {
                        line.substring(line.indexOf(" "));
                        System.out.println("____________________________________________________________\n");
                        line = line.replace("deadline", "");
                        String[] parts = line.split("/by");
                        Deadline t = new Deadline(parts[0].trim(), parts[1].trim());
                        Tasks.add(t);
                        System.out.println("Got it. I've added this task:\n");
                        System.out.println(t.toString() + "\n");
                        System.out.println("Now you have " + Tasks.size() + " tasks in the list.\n");
                        System.out.println("____________________________________________________________\n");
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        System.out.println("____________________________________________________________\n");
                        System.out.println("☹ OOPS!!! The description of a " + line + " cannot be empty.\n");
                        System.out.println("____________________________________________________________\n");
                        }
                }
                else if (line.startsWith("delete")) {
                    System.out.println("____________________________________________________________\n");
                    String[] parts = line.split(" ");
                    int i=Integer.parseInt(parts[1].trim());
                    System.out.println("Noted. I've removed this task: \n");
                    System.out.println(Tasks.get(i-1).toString() + "\n");
                    Tasks.remove(i-1);
                    System.out.println("Now you have " + Tasks.size() + " tasks in the list.\n");
                    System.out.println("____________________________________________________________\n");
                }
                else if (!line.equals("")){
                    System.out.println("____________________________________________________________\n");
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                    System.out.println("____________________________________________________________\n");
                }
                line = in.nextLine();
            }
            while(line.equals("list")){
                System.out.println("____________________________________________________________\n");
                System.out.println("Here are the tasks in your list:\n");
                for (int i = 0; i < Tasks.size(); i++){
                    System.out.println(i+1 + ". " + Tasks.get(i).toString() + "\n");
                }
                System.out.println("____________________________________________________________\n");
                line = "";

            }

        }
        System.out.println("____________________________________________________________\n");
        System.out.println(" Bye. Hope to see you again soon!\n");
        System.out.println("____________________________________________________________\n");
    }
}
