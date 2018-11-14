package works.ontheroadagain.app.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC49b748cc9ea5b7a25ec107cab88ce718";
    public static final String AUTH_TOKEN =
            "276b08043ee32fa6d2bd911664628cbb";

//    public static void main(String[] args) {
        public void sendText(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+12104152689"), // to
                        new PhoneNumber("+18302660961"), // from
                        "Your vehicle is ready for pickup?")
                .create();

        System.out.println(message.getSid());
    }
}
