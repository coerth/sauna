package dat.startcode.entities;

import java.util.Objects;

public class SaunaEvent
{
    int eventID;
    String startTime;
    int duration;
    int price;
    int participants;
    String address;

    public SaunaEvent(int eventID, String startTime, int duration, int price, int participants, String address) {
        this.eventID = eventID;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.participants = participants;
        this.address = address;
    }

    public int getEventID() {
        return eventID;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public int getParticipants() {
        return participants;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaunaEvent that = (SaunaEvent) o;
        return eventID == that.eventID && duration == that.duration && price == that.price && participants == that.participants && startTime.equals(that.startTime) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, startTime, duration, price, participants, address);
    }
}
