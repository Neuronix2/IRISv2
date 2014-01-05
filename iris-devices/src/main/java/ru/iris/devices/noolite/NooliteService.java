package ru.iris.devices.noolite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.iris.common.Config;
import ru.iris.common.SQL;
import ru.iris.common.messaging.JsonMessaging;
import java.util.Map;
import java.util.UUID;

/**
 * IRISv2 Project
 * Author: Nikolay A. Viguro
 * WWW: iris.ph-systems.ru
 * E-Mail: nv@ph-systems.ru
 * Date: 05.01.14
 * Time: 13:57
 * License: GPL v3
 */

public class NooliteService implements Runnable {

    private Logger log = LogManager.getLogger(NooliteService.class.getName());
    private boolean initComplete = false;
    private boolean shutdown = false;
    private JsonMessaging messaging;
    private Map<String, String> config;
    private SQL sql = new SQL();
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().setPrettyPrinting().create();

    // Adverstiments


    public NooliteService() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public synchronized void run() {

        messaging = new JsonMessaging(UUID.randomUUID());
        config = new Config().getConfig();

    }
}
