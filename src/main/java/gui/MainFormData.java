package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFormData {
    protected static final String VENDING_MACHINE_LABEL_KEY = "VendingMachineLabelKey";

    private PropertyChangeSupport propertyChangeSupport;

    public MainFormData() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void updateVendingDisplayLabel(String formattedVendingDisplayText) {
        propertyChangeSupport.firePropertyChange(VENDING_MACHINE_LABEL_KEY, "", formattedVendingDisplayText);
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

    public void updateCoinReturnLabel(String formattedCoinReturnText) {

    }
}
