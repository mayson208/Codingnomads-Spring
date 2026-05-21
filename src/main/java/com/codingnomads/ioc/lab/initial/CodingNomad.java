package com.codingnomads.ioc.lab.initial;

import java.text.MessageFormat;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    // constructor injection (required args)
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    // FIELD INJECTION (assignment requirement)
    @Autowired
    private Computer computer;

    // SETTER INJECTION (assignment requirement)
    private OperatingSystem operatingSystem;

    @Autowired
    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String createAwesomeSoftware() {
        return MessageFormat.format(
                "This coding nomad is creating great software using: " +
                        "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), " +
                        "Computer: ({6} {7}), OS: ({8} {9})",
                ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion(),
                computer.getBrand(),
                computer.getModel(),
                operatingSystem.getName(),
                operatingSystem.getVersion()
        );
    }
}