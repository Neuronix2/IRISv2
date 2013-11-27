package ru.iris.common.devices;

import com.google.gson.annotations.Expose;
import org.zwave4j.Manager;
import org.zwave4j.ValueId;

/**
 * IRISv2 Project
 * Author: Nikolay A. Viguro
 * WWW: iris.ph-systems.ru
 * E-Mail: nv@ph-systems.ru
 * Date: 27.11.13
 * Time: 15:33
 * License: GPL v3
 */
public class ZWaveDeviceValue {

    @Expose
    private String label = "unknown";
    @Expose
    private String value = "unknown";
    @Expose
    private String valueType = "unknown";
    @Expose
    private String valueUnits = "unknown";
    @Expose
    private boolean readOnly = false;

    private ValueId valueId;

    public ZWaveDeviceValue(String label, String value, String valueType, String valueUnits, ValueId valueId) {
        this.label = label;
        this.value = value;
        this.valueType = valueType;
        this.valueUnits = valueUnits;
        this.valueId = valueId;

        if (Manager.get().isValueReadOnly(valueId))
            this.readOnly = true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueUnits() {
        return valueUnits;
    }

    public void setValueUnits(String valueUnits) {
        this.valueUnits = valueUnits;
    }

    public ValueId getValueId() {
        return valueId;
    }

    public void setValueId(ValueId valueId) {
        this.valueId = valueId;
    }

    @Override
    public String toString() {
        return "ZWaveDeviceValue{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", valueType='" + valueType + '\'' +
                ", valueUnits='" + valueUnits + '\'' +
                ", valueId=" + valueId +
                '}';
    }
}