package works.ontheroadagain.app.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC52a50f412791bf9099a83097e8db28e0";
    public static final String AUTH_TOKEN =
            "b155eb32997dd68c88950a5fa51c9497";

//    public static void main(String[] args) {
        public void sendText(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+15122307292"), // to
                        new PhoneNumber("+15128725950"), // from
                        "Your vehicle is ready for pickup!")
                .create();

        System.out.println(message.getSid());
    }
}
