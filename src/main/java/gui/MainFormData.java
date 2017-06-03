package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFormData {
    protected static final String VENDING_MACHINE_LABEL_KEY = "VendingMachineLabelKey";

    private PropertyChangeSupport propertyChangeSupport;

    public MainFormData() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void updateVendingDisplayLabel(String displayedText) {
        propertyChangeSupport.firePropertyChange(VENDING_MACHINE_LABEL_KEY, "", displayedText);
    }

    public void addUpdateVendingDisplayLabelListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(VENDING_MACHINE_LABEL_KEY, propertyChangeListener);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

}
