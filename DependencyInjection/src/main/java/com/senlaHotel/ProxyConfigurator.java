package main.java.com.senlaHotel;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}

