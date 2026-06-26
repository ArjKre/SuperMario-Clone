# Super Mario Clone

A 2D side-scrolling platformer built with [libGDX](https://libgdx.com/) that recreates the core gameplay of the original *Super Mario Bros.* (NES). Control Mario through a faithful recreation of World 1-1 — run, jump, stomp enemies, collect coins, break bricks, and find power-ups.

## Features

- **Physics-driven movement** — Box2D-based platforming with acceleration, jumping, and collision
- **Enemies** — Goombas and Koopa Troopas with stomp, shell-kick, and chain-reaction mechanics
- **Power-ups** — Super Mushroom that makes Mario big (double height, brick-smashing, extra hit point)
- **Fireballs** — Projectiles that bounce off surfaces and destroy enemies
- **Interactive tiles** — Coin blocks, question blocks (with hidden mushrooms), and smashable bricks
- **HUD** — Score counter, world indicator, and 300-second countdown timer
- **Game Over** — Death animation with game-over screen (click to restart)
- **Camera** — Horizontally follows Mario, clamped to map boundaries

## Controls

| Key | Action |
|-----|--------|
| ← / → | Move Mario left / right |
| ↑ | Jump |
| Space | Fire a fireball |

On the Game Over screen, click anywhere to restart.

## Screenshots

<!-- TODO: Add in-game screenshots -->

## Gameplay Video

<video src="assets/gameplay.mp4" controls title="Gameplay"></video>

## Quick Start

```bash
# Run the game
./gradlew lwjgl3:run

# Build a runnable JAR
./gradlew lwjgl3:jar
# JAR is at lwjgl3/build/libs/

# Run all checks
./gradlew build
```

## Project Structure

```
core/src/main/java/com/arjkre/SuperMarioClone/
├── Main.java                     # Game entry point, constants, asset loading
├── Scenes/
│   └── Hud.java                  # In-game HUD (score, time, world)
├── Screens/
│   ├── PlayScreen.java           # Main gameplay screen
│   └── GameOverScreen.java       # Game over overlay
├── Sprites/
│   ├── Mario.java                # Player character with animations and states
│   ├── Enemies/
│   │   ├── Enemy.java            # Abstract enemy base
│   │   ├── Goomba.java           # Goomba enemy
│   │   └── Turtle.java           # Koopa Troopa enemy
│   ├── Items/
│   │   ├── Item.java             # Abstract item base
│   │   ├── ItemDef.java          # Item spawn definition
│   │   └── Mushroom.java         # Super Mushroom power-up
│   ├── Other/
│   │   └── FireBall.java         # Fireball projectile
│   └── TileObjects/
│       ├── InteractiveTileObject.java  # Abstract tile base
│       ├── Coin.java              # Coin / question block
│       └── Brick.java             # Breakable brick
└── Tools/
    ├── B2WorldCreator.java        # Parses Tiled map → Box2D world
    └── WorldContactListener.java  # Collision handling
```

## Technologies

- **[libGDX](https://libgdx.com/) 1.13.1** — Cross-platform game framework
- **[Box2D](https://box2d.org/)** — 2D physics engine
- **[LWJGL3](https://www.lwjgl.org/)** — Desktop backend
- **[Gradle](https://gradle.org/)** — Build system (wrapper included)
- **[Tiled](https://www.mapeditor.org/)** — Level editor (`.tmx` maps)
- **Java 21** — Language and toolchain

## Building

This project uses the Gradle wrapper. Useful commands:

| Command | Task |
|---------|------|
| `./gradlew lwjgl3:run` | Start the game |
| `./gradlew lwjgl3:jar` | Build a runnable JAR |
| `./gradlew build` | Build all modules |
| `./gradlew clean` | Remove build folders |
| `./gradlew --continue` | Don't stop on errors |
| `./gradlew --daemon` | Use Gradle daemon |
| `./gradlew --offline` | Use cached dependencies |
| `./gradlew idea` | Generate IntelliJ project files |
| `./gradlew eclipse` | Generate Eclipse project files |

## Platforms

- `core/` — Main module with shared application logic
- `lwjgl3/` — Desktop platform via LWJGL3

## Assets

- **Sprites:** `assets/Mario_and_Enemies.png` (texture atlas)
- **Tileset:** `assets/tileset_gutter.png`
- **Level:** `assets/level1.tmx` (World 1-1, 240×13 tiles)
- **Music:** `assets/audio/music/mario_music.ogg`
- **Sound effects:** 8 audio files in `assets/audio/sounds/`

## Credits

This project was generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).
