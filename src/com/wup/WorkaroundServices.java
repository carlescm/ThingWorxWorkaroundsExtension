package com.wup;

import com.thingworx.resources.Resource;

import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;

import org.joda.time.DateTime;

import com.thingworx.things.Thing;
import com.thingworx.types.BaseTypes;
import com.thingworx.types.constants.QualityStatus;
import com.thingworx.types.primitives.structs.VTQ;
import com.thingworx.entities.utils.ThingUtilities;

public class WorkaroundServices extends Resource  {

    private void UpdatePropertyValue(String thingName,
                String propertyName,
                Object value,
                DateTime timestamp,
                String quality,
                Boolean deferNotifications,
                Boolean bypassReadOnly,
                Boolean bypassHooksAndBindings,
                Boolean forceOverwriteCurrentValue
        ) throws Exception {
        QualityStatus qualityStatus = QualityStatus.GOOD;
        try {
            qualityStatus = QualityStatus.valueOf(quality);
        } catch (Exception exception) {}
        final Thing thing = ((Thing)ThingUtilities.findThing(thingName));
        if (thing==null) {
            throw new Exception("Unknown thing ["+thingName+"]");
        } 
        final VTQ valueVTQ = new VTQ(BaseTypes.ConvertToPrimitive(value, thing.getPropertyType(propertyName)), timestamp, qualityStatus);
        thing.setPropertyVTQ(propertyName,valueVTQ,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
    }
@ThingworxServiceDefinition(
        name = "UpdateNumberPropertyValue_WorkaroundServices", 
        description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
        category = "WUP", 
        isAllowOverride = false, 
        aspects = {"isAsync:false" }
        )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateNumberPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="NUMBER" )           Number value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateLongPropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateLongPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="LONG" )             Long value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateIntegerPropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateIntegerPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="INTEGER" )          Integer value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateStringPropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateStringPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="STRING" )           String value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateDateTimePropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateDateTimePropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="DATETIME" )         DateTime value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateBooleanPropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateBooleanPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="BOOLEAN" )          Boolean value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdateLocationPropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdateLocationPropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="LOCATION" )         Object value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

@ThingworxServiceDefinition(
    name = "UpdatePropertyValue_WorkaroundServices", 
    description = "Updates a property value, with the lost ability on TW 8.4 to write to a previous time from current property value.", 
    category = "WUP", 
    isAllowOverride = false, 
    aspects = {"isAsync:false" }
    )
@ThingworxServiceResult(name = "result", description = "", baseType = "NOTHING", aspects = {})
public void UpdatePropertyValue_WorkaroundServices(
        @ThingworxServiceParameter( name="thingName", description="", baseType="THINGNAME" )    String thingName,
        @ThingworxServiceParameter( name="propertyName", description="", baseType="STRING" )    String propertyName,
        @ThingworxServiceParameter( name="value", description="", baseType="VARIANT" )          Object value,
        @ThingworxServiceParameter( name="timestamp", description="", baseType="DATETIME" )     DateTime timestamp,
        @ThingworxServiceParameter( name="quality", description="", baseType="STRING",
                                    aspects={"isRequired:false",
                                            "defaultValue:GOOD"} )                              String quality,
        @ThingworxServiceParameter( name="deferNotifications", description="", baseType="BOOLEAN",
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean deferNotifications,
        @ThingworxServiceParameter( name="bypassReadOnly", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassReadOnly,
        @ThingworxServiceParameter( name="bypassHooksAndBindings", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"})                              Boolean bypassHooksAndBindings,
        @ThingworxServiceParameter( name="forceOverwriteCurrentValue", description="", baseType="BOOLEAN" ,
                                    aspects={"isRequired:false",
                                            "defaultValue:false"} )                             Boolean forceOverwriteCurrentValue
        ) throws Exception {
    this.UpdatePropertyValue(thingName,propertyName,value,timestamp,quality,deferNotifications,bypassReadOnly,bypassHooksAndBindings,forceOverwriteCurrentValue);
}

}
