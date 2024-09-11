package com.sistema_gestion_ventas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileGenerator {

    public static void generateFilesForEntity(String entityName, String entityPackage, List<Map<String, String>> attributes) throws IOException {
        String basePath = "src/main/java/com/sistema_gestion_ventas/" + entityPackage + "/";

        // Crear las carpetas
        new File(basePath + "application").mkdirs();
        new File(basePath + "domain/entity").mkdirs();
        new File(basePath + "domain/service").mkdirs();
        new File(basePath + "infrastructure/out").mkdirs();

        // Extraer el tipo de ID (primer atributo)
        String idType = attributes.get(0).get("type");

        // Crear la entidad
        createEntityFile(basePath + "domain/entity/" + entityName + ".java", entityPackage, entityName, attributes);

        // Crear el servicio
        createServiceFile(basePath + "domain/service/" + entityName + "Service.java", entityPackage, entityName, idType);

        // Crear los casos de uso
        createUseCaseFiles(basePath, entityPackage, entityName, idType);

        // Crear el repositorio
        createRepositoryFile(basePath + "infrastructure/out/" + entityName + "Repository.java", entityPackage, entityName, idType, attributes);

        System.out.println("Archivos para la entidad " + entityName + " creados exitosamente.");
    }

    private static void createEntityFile(String filePath, String entityPackage, String entityName, List<Map<String, String>> attributes) throws IOException {
        StringBuilder content = new StringBuilder();
        content.append("package com.sistema_gestion_ventas.").append(entityPackage).append(".domain.entity;\n\n");
        content.append("import java.util.Date;\n\n");  // Importa Date
        content.append("public class ").append(entityName).append(" {\n");

        // Atributos
        for (Map<String, String> attribute : attributes) {
            content.append("    private ").append(attribute.get("type")).append(" ").append(attribute.get("name")).append(";\n");
        }
        content.append("\n");

        // Constructor vacío
        content.append("    public ").append(entityName).append("() {}\n\n");

        // Constructor con todos los atributos
        content.append("    public ").append(entityName).append("(");
        for (int i = 0; i < attributes.size(); i++) {
            Map<String, String> attribute = attributes.get(i);
            content.append(attribute.get("type")).append(" ").append(attribute.get("name"));
            if (i < attributes.size() - 1) {
                content.append(", ");
            }
        }
        content.append(") {\n");
        for (Map<String, String> attribute : attributes) {
            content.append("        this.").append(attribute.get("name")).append(" = ").append(attribute.get("name")).append(";\n");
        }
        content.append("    }\n\n");

        // Getters y Setters
        for (Map<String, String> attribute : attributes) {
            String capitalizedAttr = capitalize(attribute.get("name"));
            content.append("    public ").append(attribute.get("type")).append(" get").append(capitalizedAttr).append("() {\n")
                    .append("        return ").append(attribute.get("name")).append(";\n")
                    .append("    }\n\n");

            content.append("    public void set").append(capitalizedAttr).append("(").append(attribute.get("type")).append(" ").append(attribute.get("name")).append(") {\n")
                    .append("        this.").append(attribute.get("name")).append(" = ").append(attribute.get("name")).append(";\n")
                    .append("    }\n\n");
        }

        // toString()
        content.append("    @Override\n");
        content.append("    public String toString() {\n");
        content.append("        return \"").append(entityName).append(" {");
        for (int i = 0; i < attributes.size(); i++) {
            Map<String, String> attribute = attributes.get(i);
            content.append(attribute.get("name")).append("=\" + ").append(attribute.get("name"));
            if (i < attributes.size() - 1) {
                content.append(" + \", ");
            }
        }
        content.append(" + \"}\";\n    }\n");

        content.append("}\n");

        writeFile(filePath, content.toString());
    }

    private static void createServiceFile(String filePath, String entityPackage, String entityName, String idType) throws IOException {
        String content = "package com.sistema_gestion_ventas." + entityPackage + ".domain.service;\n\n"
                + "import java.util.List;\n"
                + "import java.util.Optional;\n\n"
                + "import com.sistema_gestion_ventas." + entityPackage + ".domain.entity." + entityName + ";\n\n"
                + "public interface " + entityName + "Service {\n"
                + "    void create" + entityName + "(" + entityName + " " + entityPackage + ");\n"
                + "    void update" + entityName + "(" + entityName + " " + entityPackage + ");\n"
                + "    void delete" + entityName + "(" + idType + " " + entityPackage + "Id);\n"
                + "    Optional<" + entityName + "> find" + entityName + "ById(" + idType + " " + entityPackage + "Id);\n"
                + "    List<" + entityName + "> getAll" + entityName + "();\n"
                + "}\n";

        writeFile(filePath, content);
    }

    private static void createUseCaseFiles(String basePath, String entityPackage, String entityName, String idType) throws IOException {
        // Crear Use Case para Create
        createUseCaseFile(basePath + "application/Create" + entityName + "UseCase.java", entityPackage, entityName, "Create", idType);
    
        // Crear Use Case para Delete
        createUseCaseFile(basePath + "application/Delete" + entityName + "UseCase.java", entityPackage, entityName, "Delete", idType);
    
        // Crear Use Case para Update
        createUseCaseFile(basePath + "application/Update" + entityName + "UseCase.java", entityPackage, entityName, "Update", idType);
    
        // Crear Use Case para FindById
        createUseCaseFile(basePath + "application/Find" + entityName + "ByIdUseCase.java", entityPackage, entityName, "FindById", idType);
    
        // Crear Use Case para GetAll
        createUseCaseFile(basePath + "application/GetAll" + entityName + "UseCase.java", entityPackage, entityName, "GetAll", idType);
    }
    
    private static void createUseCaseFile(String filePath, String entityPackage, String entityName, String useCase, String idType) throws IOException {
        String content = "";
        switch (useCase) {
            case "Create":
                content = "package com.sistema_gestion_ventas." + entityPackage + ".application;\n\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.entity." + entityName + ";\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.service." + entityName + "Service;\n\n"
                        + "public class Create" + entityName + "UseCase {\n"
                        + "    private final " + entityName + "Service " + entityPackage + "Service;\n\n"
                        + "    public Create" + entityName + "UseCase(" + entityName + "Service " + entityPackage + "Service) {\n"
                        + "        this." + entityPackage + "Service = " + entityPackage + "Service;\n"
                        + "    }\n\n"
                        + "    public void execute(" + entityName + " " + entityPackage + ") {\n"
                        + "        " + entityPackage + "Service.create" + entityName + "(" + entityPackage + ");\n"
                        + "    }\n"
                        + "}\n";
                break;
    
            case "Delete":
                content = "package com.sistema_gestion_ventas." + entityPackage + ".application;\n\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.service." + entityName + "Service;\n\n"
                        + "public class Delete" + entityName + "UseCase {\n"
                        + "    private final " + entityName + "Service " + entityPackage + "Service;\n\n"
                        + "    public Delete" + entityName + "UseCase(" + entityName + "Service " + entityPackage + "Service) {\n"
                        + "        this." + entityPackage + "Service = " + entityPackage + "Service;\n"
                        + "    }\n\n"
                        + "    public void execute(" + idType + " " + entityPackage + "Id) {\n"
                        + "        " + entityPackage + "Service.delete" + entityName + "(" + entityPackage + "Id);\n"
                        + "    }\n"
                        + "}\n";
                break;
    
            case "Update":
                content = "package com.sistema_gestion_ventas." + entityPackage + ".application;\n\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.entity." + entityName + ";\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.service." + entityName + "Service;\n\n"
                        + "public class Update" + entityName + "UseCase {\n"
                        + "    private final " + entityName + "Service " + entityPackage + "Service;\n\n"
                        + "    public Update" + entityName + "UseCase(" + entityName + "Service " + entityPackage + "Service) {\n"
                        + "        this." + entityPackage + "Service = " + entityPackage + "Service;\n"
                        + "    }\n\n"
                        + "    public void execute(" + entityName + " " + entityPackage + ") {\n"
                        + "        " + entityPackage + "Service.update" + entityName + "(" + entityPackage + ");\n"
                        + "    }\n"
                        + "}\n";
                break;
    
            case "FindById":
                content = "package com.sistema_gestion_ventas." + entityPackage + ".application;\n\n"
                        + "import java.util.Optional;\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.entity." + entityName + ";\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.service." + entityName + "Service;\n\n"
                        + "public class Find" + entityName + "ByIdUseCase {\n"
                        + "    private final " + entityName + "Service " + entityPackage + "Service;\n\n"
                        + "    public Find" + entityName + "ByIdUseCase(" + entityName + "Service " + entityPackage + "Service) {\n"
                        + "        this." + entityPackage + "Service = " + entityPackage + "Service;\n"
                        + "    }\n\n"
                        + "    public Optional<" + entityName + "> execute(" + idType + " " + entityPackage + "Id) {\n"
                        + "        return " + entityPackage + "Service.find" + entityName + "ById(" + entityPackage + "Id);\n"
                        + "    }\n"
                        + "}\n";
                break;
    
            case "GetAll":
                content = "package com.sistema_gestion_ventas." + entityPackage + ".application;\n\n"
                        + "import java.util.List;\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.entity." + entityName + ";\n"
                        + "import com.sistema_gestion_ventas." + entityPackage + ".domain.service." + entityName + "Service;\n\n"
                        + "public class GetAll" + entityName + "UseCase {\n"
                        + "    private final " + entityName + "Service " + entityPackage + "Service;\n\n"
                        + "    public GetAll" + entityName + "UseCase(" + entityName + "Service " + entityPackage + "Service) {\n"
                        + "        this." + entityPackage + "Service = " + entityPackage + "Service;\n"
                        + "    }\n\n"
                        + "    public List<" + entityName + "> execute() {\n"
                        + "        return " + entityPackage + "Service.getAll" + entityName + "();\n"
                        + "    }\n"
                        + "}\n";
                break;
        }
        writeFile(filePath, content);
    }    
    
    private static void createRepositoryFile(String filePath, String entityPackage, String entityName, String idType , List<Map<String, String>> attributes) throws IOException {
        StringBuilder content = new StringBuilder();
        
        // Package declaration
        content.append("package com.sistema_gestion_ventas.").append(entityPackage).append(".infrastructure.out;\n\n");
        
        // Necessary imports
        content.append("import java.sql.Connection;\n")
               .append("import java.sql.DriverManager;\n")
               .append("import java.sql.PreparedStatement;\n")
               .append("import java.sql.ResultSet;\n")
               .append("import java.sql.SQLException;\n")
               .append("import java.sql.Date;\n")  // Importar java.sql.Date para fechas
               .append("import java.util.ArrayList;\n")
               .append("import java.util.List;\n")
               .append("import java.util.Optional;\n")
               .append("import java.util.Properties;\n\n");
    
        // Importing entity and service
        content.append("import com.sistema_gestion_ventas.").append(entityPackage).append(".domain.entity.").append(entityName).append(";\n")
               .append("import com.sistema_gestion_ventas.").append(entityPackage).append(".domain.service.").append(entityName).append("Service;\n\n");
    
        // Class declaration
        content.append("public class ").append(entityName).append("Repository implements ").append(entityName).append("Service {\n");
    
        // Connection field
        content.append("    private Connection connection;\n\n");
    
        // Constructor to load database properties
        content.append("    public ").append(entityName).append("Repository() {\n")
               .append("        try {\n")
               .append("            Properties props = new Properties();\n")
               .append("            props.load(getClass().getResourceAsStream(\"/db.properties\"));\n")
               .append("            String url = props.getProperty(\"url\");\n")
               .append("            String user = props.getProperty(\"user\");\n")
               .append("            String password = props.getProperty(\"password\");\n")
               .append("            connection = DriverManager.getConnection(url, user, password);\n")
               .append("        } catch (Exception e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("    }\n\n");
    
        // CREATE method
        content.append("    @Override\n")
               .append("    public void create").append(entityName).append("(").append(entityName).append(" ").append(entityPackage).append(") {\n")
               .append("        String query = \"INSERT INTO ").append(entityPackage).append(" (");
        
        // Column names for INSERT query
        for (int i = 0; i < attributes.size(); i++) {
            content.append(attributes.get(i).get("name"));
            if (i < attributes.size() - 1) {
                content.append(", ");
            }
        }
        content.append(") VALUES (");
        // Placeholders for INSERT query
        for (int i = 0; i < attributes.size(); i++) {
            content.append("?");
            if (i < attributes.size() - 1) {
                content.append(", ");
            }
        }
        content.append(")\";\n");
        
        // PreparedStatement for CREATE
        content.append("        try (PreparedStatement ps = connection.prepareStatement(query)) {\n");
        for (int i = 0; i < attributes.size(); i++) {
            Map<String, String> attribute = attributes.get(i);
            if (attribute.get("type").equals("Date")) {
                content.append("            ps.setDate(").append(i + 1).append(", new Date(")
                       .append(entityPackage).append(".get").append(capitalize(attribute.get("name"))).append("().getTime()));\n");
            } else {
                content.append("            ps.set").append(mapTypeToPreparedStatement(attribute.get("type")))
                       .append("(").append(i + 1).append(", ").append(entityPackage).append(".get").append(capitalize(attribute.get("name"))).append("());\n");
            }
        }
        content.append("            ps.executeUpdate();\n")
               .append("        } catch (SQLException e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("    }\n\n");
    
        // UPDATE method
        content.append("    @Override\n")
               .append("    public void update").append(entityName).append("(").append(entityName).append(" ").append(entityPackage).append(") {\n")
               .append("        String query = \"UPDATE ").append(entityPackage).append(" SET ");
        for (int i = 1; i < attributes.size(); i++) {  // Skip the first attribute (usually ID)
            content.append(attributes.get(i).get("name")).append(" = ?");
            if (i < attributes.size() - 1) {
                content.append(", ");
            }
        }
        content.append(" WHERE ").append(attributes.get(0).get("name")).append(" = ?\";\n");
        
        // PreparedStatement for UPDATE
        content.append("        try (PreparedStatement ps = connection.prepareStatement(query)) {\n");
        for (int i = 1; i < attributes.size(); i++) {
            Map<String, String> attribute = attributes.get(i);
            if (attribute.get("type").equals("Date")) {
                content.append("            ps.setDate(").append(i).append(", new Date(")
                       .append(entityPackage).append(".get").append(capitalize(attribute.get("name"))).append("().getTime()));\n");
            } else {
                content.append("            ps.set").append(mapTypeToPreparedStatement(attribute.get("type")))
                       .append("(").append(i).append(", ").append(entityPackage).append(".get").append(capitalize(attribute.get("name"))).append("());\n");
            }
        }
        content.append("            ps.set").append(mapTypeToPreparedStatement(attributes.get(0).get("type")))
               .append("(").append(attributes.size()).append(", ").append(entityPackage).append(".get").append(capitalize(attributes.get(0).get("name"))).append("());\n")
               .append("            ps.executeUpdate();\n")
               .append("        } catch (SQLException e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("    }\n\n");
    
        // DELETE method
        content.append("    @Override\n")
               .append("    public void delete").append(entityName).append("(" + idType + " ").append(entityPackage).append("Id) {\n")
               .append("        String query = \"DELETE FROM ").append(entityPackage).append(" WHERE ").append(attributes.get(0).get("name")).append(" = ?\";\n")
               .append("        try (PreparedStatement ps = connection.prepareStatement(query)) {\n")
               .append("            ps.set").append(mapTypeToPreparedStatement(idType)).append("(1, ").append(entityPackage).append("Id);\n")
               .append("            ps.executeUpdate();\n")
               .append("        } catch (SQLException e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("    }\n\n");
    
        // FIND BY ID method
        content.append("    @Override\n")
               .append("    public Optional<").append(entityName).append("> find").append(entityName).append("ById(" + idType + " ").append(entityPackage).append("Id) {\n")
               .append("        String query = \"SELECT * FROM ").append(entityPackage).append(" WHERE ").append(attributes.get(0).get("name")).append(" = ?\";\n")
               .append("        try (PreparedStatement ps = connection.prepareStatement(query)) {\n")
               .append("            ps.set").append(mapTypeToPreparedStatement(idType)).append("(1, ").append(entityPackage).append("Id);\n")
               .append("            try (ResultSet rs = ps.executeQuery()) {\n")
               .append("                if (rs.next()) {\n")
               .append("                    ").append(entityName).append(" ").append(entityPackage).append(" = new ").append(entityName).append("();\n");
        for (Map<String, String> attribute : attributes) {
            if (attribute.get("type").equals("Date")) {
                content.append("                    ").append(entityPackage).append(".set").append(capitalize(attribute.get("name")))
                       .append("(rs.getDate(\"").append(attribute.get("name")).append("\"));\n");
            } else {
                content.append("                    ").append(entityPackage).append(".set").append(capitalize(attribute.get("name")))
                       .append("(rs.get").append(mapTypeToResultSet(attribute.get("type"))).append("(\"").append(attribute.get("name")).append("\"));\n");
            }
        }
        content.append("                    return Optional.of(").append(entityPackage).append(");\n")
               .append("                }\n")
               .append("            }\n")
               .append("        } catch (SQLException e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("        return Optional.empty();\n")
               .append("    }\n\n");
    
        // GET ALL method
        content.append("    @Override\n")
               .append("    public List<").append(entityName).append("> getAll").append(entityName).append("() {\n")
               .append("        List<").append(entityName).append("> ").append(entityPackage).append("List = new ArrayList<>();\n")
               .append("        String query = \"SELECT * FROM ").append(entityPackage).append("\";\n")
               .append("        try (PreparedStatement ps = connection.prepareStatement(query);\n")
               .append("             ResultSet rs = ps.executeQuery()) {\n")
               .append("            while (rs.next()) {\n")
               .append("                ").append(entityName).append(" ").append(entityPackage).append(" = new ").append(entityName).append("();\n");
        for (Map<String, String> attribute : attributes) {
            if (attribute.get("type").equals("Date")) {
                content.append("                ").append(entityPackage).append(".set").append(capitalize(attribute.get("name")))
                       .append("(rs.getDate(\"").append(attribute.get("name")).append("\"));\n");
            } else {
                content.append("                ").append(entityPackage).append(".set").append(capitalize(attribute.get("name")))
                       .append("(rs.get").append(mapTypeToResultSet(attribute.get("type"))).append("(\"").append(attribute.get("name")).append("\"));\n");
            }
        }
        content.append("                ").append(entityPackage).append("List.add(").append(entityPackage).append(");\n")
               .append("            }\n")
               .append("        } catch (SQLException e) {\n")
               .append("            e.printStackTrace();\n")
               .append("        }\n")
               .append("        return ").append(entityPackage).append("List;\n")
               .append("    }\n");
    
        // End of class
        content.append("}\n");
    
        writeFile(filePath, content.toString());
    }
    
    private static String mapTypeToPreparedStatement(String type) {
        switch (type) {
            case "String":
                return "String";
            case "int":
            case "Integer":
                return "Int";
            case "double":
            case "Double":
                return "Double";
            case "Date":
                return "Date";  // Para fechas (java.sql.Date)
            default:
                return "Object";
        }
    }
    
    private static String mapTypeToResultSet(String type) {
        switch (type) {
            case "String":
                return "String";
            case "int":
            case "Integer":
                return "Int";
            case "double":
            case "Double":
                return "Double";
            case "Date":
                return "Date";  // Para fechas (java.sql.Date)
            default:
                return "Object";
        }
    }
    
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    private static void writeFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }
    

    public static void main(String[] args) {
        try {
            List<Map<String, String>> attributes = List.of(
                    Map.of("name", "tipoPersonaId", "type", "int"),
                    Map.of("name", "descripcion", "type", "String")
            );
            generateFilesForEntity("TipoPersona", "tipoPersona", attributes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


