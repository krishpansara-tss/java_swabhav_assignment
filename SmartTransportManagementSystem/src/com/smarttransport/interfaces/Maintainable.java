package com.smarttransport.interfaces;

public interface Maintainable {
    void sendToMaintenance();
    void takeFromMaintenance();
    boolean isUnderMaintenance();
}
