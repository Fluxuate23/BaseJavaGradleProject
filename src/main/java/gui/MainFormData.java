package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFormData {
    private PropertyChangeSupport propertyChangeSupport;

    public MainFormData() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void updateVendingDisplayLabel(String displayedText) {

    }

    public void addUpdateVendingDisplayLabelListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener("VendingMachineLabelKey", propertyChangeListener);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

}
