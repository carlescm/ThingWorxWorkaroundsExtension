# ThingWorx Concurrency Extension

The aim of this extension it's to provide some workarounds to bugs or bad ThingWorx R&D decisions. 

For now, it has a workaround to force update a property value to any point in time,
starting at some TW 8.X version R&D decided to not to allow to write
on current property value an "old" datapoint. If you write on a property (through standard PropertyUpdates services) a datapoint which it's older than current property value, it writes on the ValueStream (if it's logged) but doesn't updates current property thing's state. That approach it's good when receiving old buffered data, but if you want for whatever reason set back the current property value you can't, no way!

## Contents

- [Compatibility](#compatibility)
- [Installation](#installation)
- [Usage](#usage)
- [Build](#build)
- [Author](#author)

## Compatibility

ThingWorx 8.4.9 and above.

## Installation

Import the extension (WorkaroundsExtension.zip) with ThingWorx Composer Import Extension feature, the first time you won't need to restart Tomcat it will be available right-on.

## Usage

You have methods to update property value based on it's baseType 

```javascript
"Update"+baseType+"PropertyValue_WorkaroundServices" 
```
and also you have a method to update any baseType: 

```javascript
UpdatePropertyValue_WorkaroundServices
```
Usage Example:

```javascript
Resources["WorkaroundServices"].UpdatePropertyValue_WorkaroundServices({
    thingName: 				"aThingName",
    propertyName: 			"aPropertyNameOnTheThing",
    value: 					value,      // -- Whatever value to set
    timestamp: 				time,       // -- The point in time for the given value
    quality: 				quality,    // -- Default="GOOD", Quality of the datapoint
    deferNotifications:     false,      // -- Default=false, TW Internal usage,
                                        // We just published the internal parameter
    bypassReadOnly:         false,      // -- Default=false, TW Internal usage,
                                        // to be tested, seems to allow to write to a read only property, nice!
    bypassHooksAndBindings: false,      // -- Default=false, TW Internal usage,
                                        // We just published the internal parameter
    forceOverwriteCurrentValue: true    // -- Default=false, This is the new parameter that doesn' allows to write
                                        // with old values current property value, if you pass it to true you will
                                        // be able to force overwrite current property value to any point in time
                                        // Same behaviour of the old good TW.
}); 
```
## Build

If you need to build it, it's built with ant and java 8 on a MacOS, the scripts are on the repository. Version change it's done by hand and should be automated. It's built with ThingWorx Full Blown library (from the .war itself), not from 
ThingWorx SDK, as the internal service used it's not published on the SDK.

## Author

[Carles Coll Madrenas](https://linkedin.com/in/carlescoll)
