# SistemaAuthService


A Apolo Tech é responsável por um microsserviço crítico de autenticação. Para garantir 
a segurança e o desempenho, o microsserviço principal (AuthService) só pode se ligar à 
porta (SocketBind) e começar a aceitar requisições externas depois que seus quatro 
módulos essenciais de inicialização forem completamente carregados. Se o servidor 
iniciar antes da conclusão de qualquer um desses módulos (Configuração, Cache, 
Chaves de Criptografia, e Conexão de Log), ele pode falhar ou expor vulnerabilidades de 
segurança. Sabendo que o módulo de configuração leva em média 6 segundos para ser 
carregado, o de cache leva em média 9 segundos, o de chaves de criptografia em média 
12 segundos e o da conexão de log em média 4 segundos. 
A Apolo Tech precisa de uma solução robusta e concorrente para gerenciar essa 
dependência. Desta forma ela te contratou com o intuito de solucionar o seu problema, 
para isso você irá implementar um sistema de inicialização de servidor que só inicia a 
aceitação de conexões (simulada) depois que todos os módulos de configuração e 
segurança forem carregados. 