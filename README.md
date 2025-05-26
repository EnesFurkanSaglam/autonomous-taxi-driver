# Otonom Hazine Avcısı

Bu proje, JavaFX kullanılarak geliştirilmiş bir otonom hazine avcısı oyunudur. Oyuncu, haritada bulunan hazineleri toplamak için karakteri yönlendirir. Karakter, en kısa yolu bularak hazinelere ulaşır.

## Proje Yapısı

Proje, aşağıdaki ana sınıflardan oluşmaktadır:

- **HelloApplication**: Oyunun ana uygulama sınıfı. JavaFX ile kullanıcı arayüzünü oluşturur ve oyun akışını yönetir.
- **Karakter**: Oyuncunun kontrol ettiği karakterin özelliklerini ve hareketlerini tanımlar.
- **Hazine**: Haritada bulunan hazinelerin özelliklerini ve konumlarını tanımlar.
- **Engel**: Haritada bulunan engellerin temel özelliklerini tanımlar.
- **HareketliEngel**: Hareketli engellerin özelliklerini ve hareketlerini tanımlar.
- **HareketsizEngelYaz**: Yaz mevsimine ait hareketsiz engellerin özelliklerini tanımlar.
- **HareketsizEngelKis**: Kış mevsimine ait hareketsiz engellerin özelliklerini tanımlar.
- **Lokasyon**: Haritanın koordinatlarını ve engellerin konumlarını yönetir.
- **Kordinat**: Koordinat bilgilerini tutar.
- **Sis**: Haritada sis efektini oluşturur.
- **Uygulama**: En kısa yol algoritmasını içerir.

## Kullanılan Teknolojiler

- **JavaFX**: Kullanıcı arayüzü için kullanılan bir Java kütüphanesi.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi için kullanılan bir araç.

## Oyun Akışı

1. Oyun başladığında, kullanıcı harita boyutunu ve engel sayılarını belirler.
2. Harita, engeller ve hazineler rastgele yerleştirilir.
3. Karakter, en kısa yolu bularak hazinelere ulaşır.
4. Oyuncu, karakterin hareketini izler ve hazineleri toplar.
5. Oyun, tüm hazineler toplandığında sona erer.

## Kurulum

1. Projeyi klonlayın.
2. Maven ile bağımlılıkları yükleyin: `mvn install`
3. Uygulamayı çalıştırın: `mvn javafx:run`


# Autonomous Treasure Hunter

This project is an autonomous treasure hunter game developed using JavaFX. The player guides the character to collect treasures on the map. The character finds the shortest path to reach the treasures.

## Project Structure

The project consists of the following main classes:

- **HelloApplication**: The main application class of the game. Creates the user interface with JavaFX and manages the game flow.
- **Character**: Defines the properties and movements of the character controlled by the player.
- **Treasure**: Defines the properties and locations of treasures on the map.
- **Obstacle**: Defines the basic properties of obstacles on the map.
- **MovingObstacle**: Defines the properties and movements of moving obstacles.
- **StaticObstacleSummer**: Defines the properties of static obstacles for summer season.
- **StaticObstacleWinter**: Defines the properties of static obstacles for winter season.
- **Location**: Manages the coordinates of the map and the positions of obstacles.
- **Coordinate**: Holds coordinate information.
- **Fog**: Creates the fog effect on the map.
- **Application**: Contains the shortest path algorithm.

## Technologies Used

- **JavaFX**: A Java library used for the user interface.
- **Maven**: A tool used for project management and dependency management.

## Game Flow

1. When the game starts, the user determines the map size and number of obstacles.
2. The map, obstacles, and treasures are randomly placed.
3. The character finds the shortest path to reach the treasures.
4. The player watches the character's movement and collects treasures.
5. The game ends when all treasures are collected.

## Installation

1. Clone the project.
2. Install dependencies with Maven: `mvn install`
3. Run the application: `mvn javafx:run` 