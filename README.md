# SearchEngine

Projeto criado como solução para o desafio proposto pela LuizaLabs. Busca por uma sentença em todos os arquivos em uma 
determinada pasta e exibe quantos e quais arquivos possuem a palavra-chave. 

## Instalação

O prjeto preziza ser clonado:

```sh
$ git clone https://github.com/angelobms/search-engine.git
$ cd search-engine
```

Após clonar o projeto, abra ele na IDE IntelliJ IDEA e faça o BUILD. Depois execute o seguinte comando para instalação:

```sh
jar cvfm search.jar MANIFEST.MF -C out/production/SearchEngine/ . jar cvfm search.jar MANIFEST.MF -C out/production/SearchEngine/ . 
```

## Execução

Copie o executavel .jar para a pasta ao qual deseja fazer a pesquise e execute-o com o comando abaixo:

```sh
$ java -jar search.jar walt disney
```

Onde "walt disney" foi a sentença utilizada para a pesquisa como exemplo.
