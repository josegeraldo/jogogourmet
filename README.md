# Jogo Gourmet

#### Consiste em uma árvore de decisões que "aprende" com o feedback do usuário para determinar um prato determinado

#### Feito como desafio técnico de uma seleção de emprego

# Arquitetura da aplicação

- Separação de pacotes de domínio e implementação, com o caso de uso de JogoGourmet em swing em uma classe separada e uma interface que abstrai para a classe Main (que faz o papel de cliente) a implementação do jogo. Dessa forma, o cliente pode substituir a implementação do jogo se houver outra classe concreta implementando a interface com o método play


- A classe Node é uma árvore de decisão, com os nós que estruturam a decisão Sim ou Não tomadas pelo usuário


- A classe NodeTraversalService é um serviço de percurso da árvore. Dessa forma, há uma separação das responsabilidades da classe que implementa o play: a classe JogoGourmetSwing se atém a usar NodeTraversalService como um cliente, recebendo a instância desta classe por injeção de dependência


- A implementação de play em JogoGourmetSwing percorre todos os nós da árvore, e se não encontrar resposta, altera a árvore inserindo um novo nó de decisão, como uma árvore que "aprende" o input passado pelo usuário


- Projeto criado com maven para manter a convenção sobre a configuração dos diretórios de código-fonte e de compilação. Jar gerado por meio do mvn package, que produz um jar no diretório target


- O diretório src/test/java possui as classes de teste com a biblioteca junit, que foi adicionada como dependência no pom.xml. Foram adicionados poucos testes da classe NodeTraversalService como prova de conceito, porém a intenção seria inserir muitos testes nestas classes a fim de validar a implementação do service. Dessa forma, o próprio maven exibe informação de problema no build ao rodar mvn package se houver algum problema na implementação da classe sendo testada.
