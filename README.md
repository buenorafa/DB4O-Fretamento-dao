# Chartering System Project README

This repository contains the implementation of a chartering system developed as part of the Object Persistence course project at IFPB. The system is designed to manage chartering operations using Java, db4o for object persistence, DAO pattern for data access, and Swing for the graphical user interface.

## Task List for System Construction

### Analysis and Preparation

1. **Requirements Analysis**
   - **Identified Entities**:
     - Viagem (Trip): id, data (date), destino (destination), veículo (vehicle), motorista (driver)
     - Motorista (Driver): cnh (driver's license), nome (name), lista de viagens (list of trips)
     - Veículo (Vehicle): placa (license plate), modelo (model), lista de viagens (list of trips)
   - **Business Rules**:
     - No two trips of the same car can occur on the same date.
   - **Queries**:
     - List trips for date D.
     - List trips with plate X and driver's license Y.
     - List drivers with more than N trips.

### Environment Setup

1. **Development Environment Setup**
   - Configure IDE (IntelliJ IDEA or Eclipse).
   - Add db4o libraries to the project.
   - Setup Swing for the graphical user interface.

### System Implementation

1. **Business Model Implementation (1 point)**
   - Create Java classes for `Viagem` (Trip), `Motorista` (Driver), and `Veículo` (Vehicle) with the mentioned attributes.
   - Implement getter and setter methods for the attributes.
   - Implement methods to manage trip lists in `Motorista` and `Veículo`.
2. **Implementation of DAO Classes (1 point)**

   - Create specific DAO classes for `ViagemDAO`, `MotoristaDAO`, and `VeículoDAO`.
   - Implement CRUD methods: `create`, `read`, `update`, `delete`.
   - Implement `read(Object)` method and the 3 specific queries mentioned in the task.
   - Configure the `Util` class to initialize and configure the db4o database.

3. **Facade Class Implementation (2 points)**

   - Create the `Fachada` (Facade) class that encapsulates the system's requirements.
   - Implement methods to create, update, delete, and list objects for each business class.
   - Implement business rules within the `Fachada` class, especially the rule preventing two trips of the same car on the same date.

4. **Console Applications Development (1 point)**

   - **Cadastrar.java**: Implement for registering various business model objects.
   - **Listar.java**: Implement to list all registered objects.
   - **Consultar.java**: Implement to list the 3 specific queries from the task.

5. **Graphical Applications Development (1 point)**
   - Implement a Swing screen for each business class (`Viagem`, `Motorista`, `Veículo`) to create, update, delete, and list.
   - Implement a Swing screen for the 3 specific queries mentioned in the task.

### Testing and Validation

1. **Unit and Integration Testing**
   - Create unit tests for business model classes.
   - Create tests for DAO classes and methods of the `Fachada` class.
   - Perform integration tests to ensure all layers function correctly together.

### Documentation and Presentation

1. **Documentation**

   - Document code with explanatory comments.
   - Create a user manual to explain how to use the system.

2. **Project Presentation (4 points)**
   - Prepare a presentation to demonstrate the system's functionality.
   - Include explanations about the architecture, implementation, and challenges encountered.
   - Present the project according to the provided guidelines, ensuring each group member participates.

### Task Summary

- **Theme analysis and requirements definition**: Identify entities, business rules, and queries.
- **Development environment configuration**: Prepare IDE, db4o, and Swing.
- **Implementation**: Develop business model, DAO classes, `Fachada` class, console and graphical applications.
- **Testing and validation**: Execute unit and integration tests.
- **Documentation and presentation**: Document the project and prepare the presentation.

### Notes

- **Participation in the presentation**: The presentation is mandatory for each student to receive a grade.
- **Layered architecture**: Follow the architecture as described in the document.
