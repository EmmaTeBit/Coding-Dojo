package Basics.AlfredBot;
import java.util.Date;

    public class AlfredQuotes {
    
        public String basicGreeting() {
            return "Hello, lovely to see you. How are you?";
        }
        
        public String guestGreeting(String name, String dayPeriod) {
            return "Good "+ dayPeriod + "," + name + ". Lovely to see you.";
            //or
            // return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
        }
        
        public String dateAnnouncement() {
            Date date = new Date();
            return "It is currently " + date + ".";
            //or
            //return String.format("It is currently %s", new Date());
        }
        
        public String respondBeforeAlexis(String phrase) {
            // YOUR CODE HERE
            if(phrase.indexOf("Alexis") > -1) {
                return "She's really of no help. What can I get for you?";
            }
    
            if (phrase.indexOf("Alfred") > -1) {
                return "At your service, naturally. How may I be of assistance?";
            }
    
            return "Right. And with that I shall retire.";
        }        

}


