// Interface for Notifications
interface Notifiable {
    void sendNotification(String message, String recipient);
}

// Email Notification
class EmailNotification implements Notifiable {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Email to " + recipient + ": " + message);
    }
}

// SMS Notification
class SMSNotification implements Notifiable {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("SMS to " + recipient + ": " + message);
    }
}

// Notification Service
class NotificationService {
    private Notifiable emailService = new EmailNotification();
    private Notifiable smsService = new SMSNotification();

    public void notifyDoctor(String message) {
        emailService.sendNotification(message, "doctor@example.com");
        smsService.sendNotification(message, "+1234567890");
    }
}

// Emergency Alert System
class EmergencyAlert {
    private NotificationService notifier = new NotificationService();

    public void checkVitals(double heartRate, double temperature) {
        if (heartRate > 120 || temperature > 39.0) {
            notifier.notifyDoctor("Critical vitals detected! Heart Rate: " + heartRate + ", Temperature: " + temperature);
        } else {
            System.out.println("Vitals are within normal range.");
        }
    }
}

// Panic Button
class PanicButton {
    private NotificationService notifier = new NotificationService();

    public void press() {
        notifier.notifyDoctor("Emergency Panic Button Pressed by Patient!");
    }
}

// Chat Server
class ChatServer {
    public void receiveMessage(String message, String fromUser) {
        System.out.println("Message from " + fromUser + ": " + message);
    }
}

// Chat Client
class ChatClient {
    private ChatServer server;

    public ChatClient(ChatServer server) {
        this.server = server;
    }

    public void sendMessage(String message, String fromUser) {
        server.receiveMessage(message, fromUser);
    }
}

// Video Call
class VideoCall {
    public void startCall(String platform) {
        if (platform.equalsIgnoreCase("zoom")) {
            System.out.println("Opening Zoom link: https://zoom.us/j/123456789");
        } else {
            System.out.println("Opening Google Meet link: https://meet.google.com/abc-defg-hij");
        }
    }
}

// Reminder Service
class ReminderService {
    private Notifiable email = new EmailNotification();
    private Notifiable sms = new SMSNotification();

    public void sendAppointmentReminder(String patient) {
        email.sendNotification("Reminder: Appointment at 10 AM tomorrow.", patient);
        sms.sendNotification("Reminder: Appointment at 10 AM tomorrow.", patient);
    }

    public void sendMedicationReminder(String patient) {
        email.sendNotification("Reminder: Take your medicine at 8 PM.", patient);
        sms.sendNotification("Reminder: Take your medicine at 8 PM.", patient);
    }
}

// Main Application
public class RemoteHealthMonitoringSystem {
    public static void main(String[] args) {
        System.out.println("=== Remote Health Monitoring System Demo ===");

        // Emergency Alert System
        EmergencyAlert alert = new EmergencyAlert();
        alert.checkVitals(130, 38.5);  // critical vitals

        PanicButton panic = new PanicButton();
        panic.press();  // panic alert

        // Chat Simulation
        ChatServer server = new ChatServer();
        ChatClient doctor = new ChatClient(server);
        ChatClient patient = new ChatClient(server);

        doctor.sendMessage("Hello, how are you feeling today?", "Doctor");
        patient.sendMessage("I'm feeling nauseous.", "Patient");

        // Video Call
        VideoCall call = new VideoCall();
        call.startCall("meet");  // video consultation

        // Reminders
        ReminderService reminders = new ReminderService();
        reminders.sendAppointmentReminder("patient@example.com");
        reminders.sendMedicationReminder("patient@example.com");
    }
}

