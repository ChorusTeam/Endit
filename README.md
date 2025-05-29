# Endit
> A lightweight and highly configurable utility mod designed for server operators who need fine-grained control over the End dimension’s spawn platform location. By default, Minecraft places players on a fixed obsidian platform upon entering the End. Endit allows you to override this behavior, giving you the ability to define a custom spawn position for the End portal arrival platform.

![Command](https://github.com/ChorusTeam/Endit/blob/master/command.png?raw=true)
![End Platform](https://github.com/ChorusTeam/Endit/blob/master/in_end_platform.png?raw=true)

Key Features:
* Custom Spawn Location: Easily set a new spawn position in the End dimension using the in-game command `/setendspawn <x y z>`.
* Server Configuration Support: All spawn coordinates are saved and persisted via the mod’s server-side config file.
* Access Control: Only players with operator (level 2+) permissions can execute the command, ensuring secure usage.
* Validation and Safety Checks: The mod includes built-in checks to prevent setting spawn coordinates outside world borders or invalid vertical ranges.
* Seamless Integration: Fully compatible with vanilla servers and modpacks; requires no client-side installation.