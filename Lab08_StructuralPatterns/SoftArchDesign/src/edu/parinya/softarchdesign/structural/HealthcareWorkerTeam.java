package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private final Set<HealthcareServiceable> members = new HashSet<>();

    public void addMember(HealthcareServiceable member) {
        this.members.add(member);
    }

    public void removeMember(HealthcareServiceable member) {
        this.members.remove(member);
    }

    @Override
    public double getPrice() {
        double price = 0;
        for(HealthcareServiceable member : members) { price += member.getPrice(); }
        return price;
    }
    @Override
    public void service() {
        for(HealthcareServiceable member : members) { member.service(); }
    }
}
