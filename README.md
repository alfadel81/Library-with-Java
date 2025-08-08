# Java Library Management System

A comprehensive library management system built with Java that allows users to manage various types of library resources including books, magazines, and newspapers.

## Features

- **Resource Management**: Handle different types of library resources (Books, Magazines, Newspapers)
- **Borrowing System**: Track borrowed items with due dates and borrower information
- **Search Functionality**: Find resources by various criteria
- **Reservation System**: Allow users to reserve items that are currently checked out
- **Categorization**: Organize items by genres and periodicities

## Project Structure

```
src/
├── model/                 # Core business logic and data models
│   ├── Book.java          # Book resource implementation
│   ├── Magazine.java      # Magazine resource implementation
│   ├── Newspaper.java     # Newspaper resource implementation
│   ├── Library.java       # Main library management class
│   ├── Resource.java      # Base class for all library resources
│   ├── Item.java          # Item management
│   ├── Media.java         # Media resource implementation
│   ├── Service.java       # Library services implementation
│   ├── Genre.java         # Genre enumeration
│   ├── Periodicity.java   # Periodicity enumeration
│   ├── Borrowable.java    # Interface for borrowable items
│   ├── Reservable.java    # Interface for reservable items
│   ├── Searchable.java    # Interface for search functionality
│   └── Main.java          # Entry point
└── view/
    └── Console.java       # Console-based user interface
```

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven (for dependency management)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/alfadel81/Library-with-Java.git
   cd Library-with-Java
   ```

2. Compile the project:
   ```bash
   javac -d bin src/model/*.java src/view/*.java
   ```

### Running the Application

```bash
java -cp bin model.Main
```

## Usage

1. Start the application
2. Use the console interface to:
   - Add/remove library resources
   - Borrow/return items
   - Search the catalog
   - Manage reservations
   - View available resources

## Design Patterns

- **Factory Pattern**: For creating different types of resources
- **Strategy Pattern**: For implementing different search strategies
- **Observer Pattern**: For notifying users about reserved items
- **Singleton Pattern**: For the Library class to ensure only one instance exists

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

[Your Name]

## Acknowledgments

- [List any references or inspiration here]
