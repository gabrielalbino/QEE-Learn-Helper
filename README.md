# AprendaQEE
##### Software para simulações feito para disciplina Qualidade de Energia Elétrica. 

### Manual do usuário
> O Programa possui 3 simulações disponíveis:
> * Simular fluxo de potência fundamental 
> * Simular Distorção Harmônica
> * Simular fluxo de potência harmônica

> Para compilar e executar:

> Requisitos:
> + Eclipse Oxygen

>Como Rodar:
> + Importe o projeto
> + Clique com o botão direito no projeto -> Run as -> Java application

> Requisitos implementados:
> + Modelagem: O diagrama de classes UML encontra-se na pasta de documentação do software

> + MVC: O código fonte do projeto foi dividido em 3 partes: Model, View e Controller, sendo que na pasta View se encontra os arquivos que possuem entrada ou saída de dados, na pasta Controller encontram-se as classes que realizam calculos e valida��es e na pasta Model encontra-se os arquivos que  armazenam valores.

> + Java Swing: Foi implementada uma interfáce utilizando a biblioteca Swing do Java, sendo a interface mais intuitiva possível.

> + Associação: Os gráficos e o triângulo de potência, assim como as classes de calculo foram criadas por agregação, enquanto as janelas dos usos de caso são agregadas à janela principal.

> + Interface: Foi criada uma interface para as classes de calculo que contem a função para calcular, nos Calculos de cada uso de caso ela é implementada de modo que calcule todos os requisitos necessários.

> + Testes unitários: Foi implementado teste unitário na classe CalculosUC2

> + Resolução do Problema: Todos os dados de saída do programa foram compatíveis com os resultados disponíveis no documento de visão.

> + Tratamento de exceções: Todas as excessões lançadas tanto pelos metodos set quanto pelos métodos padrões do Swing/JavaJDK foram tratadas e, quando necessário, informado ao usuário a causa do problema e uma possível solução.

> + Boas práticas de desenvolvimento: Foi utilizado modularização e nomes de variaveis/métodos significativos.

> + Uso do repositório e Versionamento: Todas as mudanças foram commitadas com comentários precisos e coerentes.

> + Threads: Não implementado.