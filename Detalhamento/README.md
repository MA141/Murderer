# Grupo MA141
<p>Guilherme Zeferino Rodrigues Dobins, RA:236129
<p>Artur Abreu Hendler, RA:231713

# Detalhamento do Projeto
[Link dos slides](https://docs.google.com/presentation/d/1pCGv_wNoytKBnk53aXQAfj_TzJ8oRLM61EuP9PZzEOQ/edit?ts=5ec3fd09#slide=id.g858dc2d46b_0_18)
<p>O jogo Murderer é representado, em UML, pelas seguintes partes:

## Componentes:
![](components.png)
#### Uma partida, do ponto de vista dos compontentes, ocorreria assim:
<p>Iniciado o programa, o Componentente Player fornece ao Board a localizaçao inicial das peças (Caçador, sobrevivente, arma e partes do rádio), que por sua vez cria de fato o tabuleiro e as posiciona. Esse então fornece uma instância do tipo Board ao componente State, que computa o Tempo jogado e busca por um vencedor, e ao componente Pieces, que gera as jogadas das peças dinâmicas (Sobrevivente e Caçador). O jogo então continua dessa forma, com as jogadas das peças dinâmicas sendo feitas até que o State determine que o jogo acabou, entreguando o resultado ao Player.

## Interfaces, classes e seus respectivos métodos e instâncias:
* IBoard:<p>
![](UMLBoard.png)
  * Métodos:
     * Board: Construtor. Recebe uma variável do tipo IInitial com as coordenadas dos itens (passadas pelo jogador) e cria o tabuleiro.
     * move: Recebe como paramâmetro as coordenadas do tabuleiro para as quais os personagens (sobrevivente e caçador) desejam ir e realiza essa movimentação no tabuleiro.
     * getPosRadio1: Retorna as coordenadas da primeira peça do rádio.
     * getPosRadio2: Retorna as coordenadas da segunda peça do rádio.
     * getPosRadio3: Retorna as coordenadas da terceira peça de rádio.
     * getPosGun: Retorna as coordenadas da arma.
     * getPosMurderer: Retorna as coordenadas do caçador.
     * getPosSurvivor: Retorna as coordenadas do sobrevivente.
  * Instancias: 
     * tab: Vetor bidimensional que armazena as peças, funcionando como um tabuleiro.
     * positions: Vetor bidimensional que armazena as coordenas das peças chaves (Caçador, Sobrevivente, Rádio e Arma).
* IPieceStatic:<p>
 ![](UMLPieceStatic.png)
  * Métodos:
     * collected: Retorna o estado da arma (true, se foi coletada, e false caso contrário).
     * ammo: Retorna a munição restante na arma.
  * Instancias:
     *status: Armazena o estado da arma (0, se ainda não foi coletada, e 1 se foi coletada).
* IPieceDynamic:<p>
![](IPieceDynamic.png)
  * Métodos:
     * getPosicaoInimigo: Retorna a posição do Caçador no caso do Sobrevivente e vice-versa. 
     * getPosicao: Retorna as coordenadas da peça que o chamou.
     * move: Analisa a vizinhança da peça e retorna o as coordenadas do tabuleiro para qual ela deseja se mover.
   * Instancias: 
     * board: Guarda uma variável da classe Board.
     * radio: Armazena uma variável da classe radio (numero de peças de radio conseguidas).
     * gun: Armazena uma variável da classe gun (quantidade de munição disponível).
     * speed: Armazena a velocidade do Caçador (blocos por turno).
 * ITime e IResult:<p>
 ![](State.png)
   * Métodos:
     * getTime: Retorna o número de turnos já jogados.
     * getResult: Retorna o estado atual do jogo (Vítóra do Sobrevivente, Vitória do caçador ou Em andamento).
   * Instâncias:
     * Time: Armazena o número de turnos já jogados.
     * Result: Guarda o estado atual do jogo.
     * board: Armazena uma variável da classe Board.
* IInitial:<p>
![](Playerv2.png)
   * Métodos:
     * getInitialPosition: Retorna um vetor bidimensional com as posições inciais das peças.
     * setInitialPosition: Estabelece as posições iniciais.
     * isOver: Finaliza o jogo e Informa o usuário.
   * instâncias:
     * initialPositions: Armazena as posições iniciais.
     * state: Armazena uma variável da classe State.
 
 
