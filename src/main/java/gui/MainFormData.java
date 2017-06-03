package gui;

import java.beans.PropertyChangeSupport;

public class MainFormData {
    private PropertyChangeSupport propertyChangeSupport;

    public MainFormData() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void updateVendingDisplayLabel(String displayedText) {

    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}
