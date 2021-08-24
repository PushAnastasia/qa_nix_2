package ua.com.alevel;

import ua.com.alevel.data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanetReporter {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            prompt();
            while ((input = reader.readLine().toLowerCase()) != null) {
                print(input);
                input = reader.readLine().toLowerCase();
                if (input.equals("0")) {
                    System.exit(0);
                }
                print(input);
            }
        } catch (IOException e) {
            System.out.println("problem: " + e.getMessage());
        }
    }

    private void prompt() {
        System.out.println("Please, enter the name of the planet to get the acceleration of gravity on this planet.");
        System.out.println("For example, enter Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus or Neptune.");
        System.out.println("Enter all to get the acceleration of gravity for each planet in the Solar System");
        System.out.println("If you want to exit, please enter 0");
    }

    private void print(String input) {
        SolarSystem mercury = new Mercury();
        SolarSystem venus = new Venus();
        SolarSystem earth = new Earth();
        SolarSystem mars = new Mars();
        SolarSystem jupiter = new Jupiter();
        SolarSystem saturn = new Saturn();
        SolarSystem uranus = new Uranus();
        SolarSystem neptune = new Neptune();
        switch (input) {
            case "mercury":
                printPlanetInfo(mercury);
                break;
            case "venus":
                printPlanetInfo(venus);
                break;
            case "earth":
                printPlanetInfo(earth);
                break;
            case "mars":
                printPlanetInfo(mars);
                break;
            case "jupiter":
                printPlanetInfo(jupiter);
                break;
            case "saturn":
                printPlanetInfo(saturn);
                break;
            case "uranus":
                printPlanetInfo(uranus);
                break;
            case "neptune":
                printPlanetInfo(neptune);
                break;
            case "all":
                printPlanetInfo(mercury);
                printPlanetInfo(venus);
                printPlanetInfo(earth);
                printPlanetInfo(mars);
                printPlanetInfo(jupiter);
                printPlanetInfo(saturn);
                printPlanetInfo(uranus);
                printPlanetInfo(neptune);
                break;
            default:
                System.out.println("Entered value does not match any Solar system planet. Please try again.");
        }
        prompt();
    }

    private void printPlanetInfo(SolarSystem planet) {
        System.out.println(planet.getClass().getSimpleName() + "is the " + planet.getCountFromSun() +
                " planet from the Sun. Its acceleration of gravity is " + planet.getAccelerationOfGravity());
        System.out.println();
    }
}
