void main(){
    Scanner sc = new Scanner(System.in);

    List<Employee> employees = new ArrayList<>();

    IO.print("Caminho do arquivo: ");
    String caminho = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
        String linha = br.readLine();

        while(linha != null) {
            String[] campos = linha.split(",");
            String name = campos[0];
            String email = campos[1];
            Double salary = Double.parseDouble(campos[2]);

            employees.add(new Employee(name, email, salary));
            linha = br.readLine();
        }

        IO.print("Digite um valor: ");
        double salary = sc.nextDouble();

        IO.print("Digite uma letra para buscar: ");
        String letra = sc.next();

        double total = employees.stream()
                .filter(e -> e.getSalary() > salary)
                .mapToDouble(e -> e.getSalary())
                .sum();

        double totalM = employees.stream()
                .filter(e -> e.getName().startsWith(letra))
                .mapToDouble(e -> e.getSalary())
                .sum();

        List<String> email = employees.stream()
                .filter(e -> e.getSalary() > salary)
                .map(e -> e.getEmail())
                .sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
                .collect(Collectors.toList());


        email.forEach(IO::println);
        IO.println("Total salários acima de R$ " + String.format("%.2f", salary) + ": R$ " + String.format("%.2f", total));
        IO.println("Total salários que começam com a letra" + " '" + letra + "' " + ": R$ " + String.format("%.2f", totalM));

    } catch (IOException err) {
        IO.println("Erro: " + err.getMessage());
    }




    sc.close();
}

class Employee {
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}