package examples.books.refactoring_guru.bridge.example;

import examples.books.refactoring_guru.bridge.example.devices.Device;
import examples.books.refactoring_guru.bridge.example.devices.Radio;
import examples.books.refactoring_guru.bridge.example.devices.Tv;
import examples.books.refactoring_guru.bridge.example.remotes.AdvancedRemote;
import examples.books.refactoring_guru.bridge.example.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
