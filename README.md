# email
Aplicação com arquitetura de microserviços de negocios com comunicação assincrona utilizando-se de messagira e o broker rabbitmq onde a aplicação usuario
que está também postada aqui no github cadastra um usuário e produz uma mensagem que é enviada ao broker que por sua vez envia para uma outra aplicação
chamada email ,essa aplicação irá consumir esta mensagem e posteriormente enviará para um email do gmail configurado na aplicação
