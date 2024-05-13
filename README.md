**Sistema de Reservas de Hotel**
Este é um sistema de reservas de hotel construído com Spring Boot, que permite aos usuários realizar reservas de quartos de hotel e cancelar reservas existentes. O sistema é composto por várias classes e componentes que trabalham juntos para fornecer essa funcionalidade.

**Funcionalidades**
O sistema oferece as seguintes funcionalidades:

Reservar Quarto: Os usuários podem solicitar a reserva de um quarto de hotel, especificando a data de check-in, a data de check-out, e outras informações relevantes.

Cancelar Reserva: Os usuários podem cancelar uma reserva existente, fornecendo o ID da reserva.

**Componentes Principais**
Hotel
O componente Hotel representa um hotel e possui os seguintes atributos:

id: Identificador único do hotel.
nome: Nome do hotel.
localizacao: Localização do hotel.
quartosIds: Lista de IDs dos quartos disponíveis neste hotel.
Quarto
O componente Quarto representa um quarto de hotel e possui os seguintes atributos:

id: Identificador único do quarto.
tipo: Tipo de quarto (por exemplo, "Single", "Double").
capacidade: Capacidade do quarto (número de pessoas que podem ocupar o quarto).
disponivel: Indica se o quarto está disponível para reserva.
HotelService
O serviço HotelService é responsável por gerenciar os hotéis e fornece métodos para pesquisar hotéis disponíveis com base na data e localização especificadas.

**QuartoService**
O serviço QuartoService é responsável por gerenciar os quartos de hotel e fornece métodos para adicionar quartos e recuperar informações sobre quartos específicos.

**ReservationRequest**
A classe ReservationRequest representa uma solicitação de reserva feita pelo usuário e possui os seguintes atributos:

reservationId: Identificador único da reserva.
roomId: ID do quarto a ser reservado.
userId: ID do usuário que fez a reserva.
email: Endereço de e-mail do usuário.
checkInDate: Data de check-in da reserva.
checkOutDate: Data de check-out da reserva.
ReservationController
O controlador ReservationController é responsável por lidar com as solicitações HTTP relacionadas a reservas de quartos de hotel. Ele fornece endpoints para reservar quartos e cancelar reservas existentes.

**EmailService e EmailServiceImpl**
O serviço EmailService define um contrato para enviar e-mails de confirmação e cancelamento de reservas. O EmailServiceImpl é uma implementação concreta desse serviço, que simula o envio de e-mails para fins de demonstração.

**Executando a Aplicação**
Para executar a aplicação, siga estas etapas:

Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.
Clone este repositório em sua máquina local.
Navegue até o diretório raiz do projeto.
Execute o comando ./mvnw spring-boot:run (no Windows, use mvnw spring-boot:run) para iniciar o servidor da aplicação.
Uma vez que o servidor esteja em execução, você pode acessar a API RESTful para fazer solicitações de reserva e cancelamento.
Exemplos de Uso
Reservar um Quarto
Para reservar um quarto, faça uma solicitação HTTP POST para /reservations com o seguinte corpo JSON:

json
Copy code
{
  "roomId": "101",
  "userId": "123",
  "email": "example@example.com",
  "checkInDate": "2024-05-20",
  "checkOutDate": "2024-05-25"
}
**Cancelar uma Reserva**
Para cancelar uma reserva existente, faça uma solicitação HTTP DELETE para /reservations/{reservationId}, onde {reservationId} é o ID da reserva que você deseja cancelar.

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas e enviar solicitações pull.
