package com.paaste.coopy.backend.configuration;

import com.paaste.coopy.backend.domain.model.PickupPlace;
import com.paaste.coopy.backend.infrastructure.UserRepository;
import com.paaste.coopy.backend.user.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class UserRepositoryInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserRepository userRepository = (UserRepository) event.getApplicationContext().getBean("MockUserRepository");

        SecureRandom secureRandom = new SecureRandom();
        double latitude = 52;
        double longitude = 16;

        for(int i =0 ; i < 10 ; i++) {

            Location location = new Location(latitude + i*0.001, longitude - 0.001*i);
            Address address = new Address(location,"Poznań","Grunwaldzka");
            HomeAddress homeAddress = new HomeAddress(address, Integer.toString(i));

            Location pickupLocation = new Location(latitude + secureRandom.nextDouble() , longitude + secureRandom.nextDouble());
            Address pickupAddress = new Address(pickupLocation, "Poznan", "Półwiejska");

            PickupPlace pickupPlace = new PickupPlace("POZ" + i, pickupAddress);
            PreferredPickupPlace preferredPickupPlace = new PreferredPickupPlace(pickupPlace);

            User user = new User(i,homeAddress , preferredPickupPlace);
            System.out.println(user);
            userRepository.save(user);
        }
    }
}
