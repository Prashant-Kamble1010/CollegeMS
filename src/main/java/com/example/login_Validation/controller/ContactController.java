

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/sendMessage")
    public String sendMessage(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            Model model) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("prashantkamble4208@gmail.com");
        mail.setSubject("CollegeMS Contact Form");

        mail.setText(
                "Name : " + name +
                        "\nEmail : " + email +
                        "\nMessage : " + message);

        mailSender.send(mail);

        model.addAttribute(
                "success",
                "Message Sent Successfully");

        return "contact";
    }
}