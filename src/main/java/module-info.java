module com.pocket {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires commons.io;
    exports com.pocket;
    exports com.pocket.model;
    exports com.pocket.controllers;
    exports com.pocket.exceptions;
    exports com.pocket.services;
    opens com.pocket.controllers;
    opens com.pocket.model;

}