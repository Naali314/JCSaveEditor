# Jade Cocoon Savegame Editor

This repo holds the source files used to make a simple Jade Cocoon Savegame Editor.

Prerequisites
-
The editor was built using *IntelliJ* GUI Designer and *Java 8*. In order to build the forms correctly, make sure the
setting under Settings > Editor > GUI Designer > Generate GUI into is set to "Java source code". This will generate
methods like "$$$setupUI$$$" which build the UI for each form whenever the project is built.

Memory cards created by emulators are usually exactly 131.072 bytes large, so those are accepted by the editor. For some
documentation of PS1 memory card formats, see https://www.psdevwiki.com/ps3/PS1_Savedata

Basic Usage
-
Please remember to backup saves first, in case something goes wrong!

* Build the project and run the class Main as an application. Click "Open file..." to load a memory card.
* Choose a savegame to edit. Edit whatever you want.
* Click "Finish" for each savegame you're done editing.
* Finished? Click "Save" or "Save As ..." to *actually* save the memory card with your changes.

Supported Game Versions
-
All version of Jade Cocoon except for the japanese ones should be supported and good to go.