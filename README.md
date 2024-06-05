![image](https://github.com/Nonopichy/M4AtoMP3/assets/68911691/b398c5a2-6f2b-4d73-bc96-a8bfe8d79665)

# M4AtoMP3

## Dependências:
- Java 1.8.0 (Java 8)
- FFmpeg

## Como instalar o FFmpeg?
1. Vá até o site [FFmpeg Builds Releases](https://github.com/BtbN/FFmpeg-Builds/releases) e baixe o win-glp correspondente ao seu sistema.
2. Crie uma pasta em `C:/` chamada "ffmpeg".
3. Dentro desta pasta, descompacte o arquivo baixado. Certifique-se de que as pastas "bin" e "doc" estão presentes dentro da pasta "ffmpeg".
4. Defina a variável de ambiente. Na barra de pesquisa do Windows, pesquise por "editar as variáveis de ambiente do sistema". Clique em "Variáveis de Ambiente" logo abaixo.
5. No grupo "Variáveis do sistema", clique em "Novo". Nomeie a variável como "ffmpeg" e insira o valor "C:/ffmpeg/bin". Clique em OK.
6. Para garantir o funcionamento, procure a variável chamada "Path" no grupo "Variáveis do sistema". Dê dois cliques sobre ela.
7. Na lista de caminhos, clique em "Novo" no canto superior direito e adicione "C:/ffmpeg/bin". Clique em OK duas vezes.
8. Para verificar se está correto, pressione Win + R e digite "cmd". Dentro do prompt de comando, digite "ffmpeg -version". Se exibir várias informações, está tudo certo!

## Como executar o M4AtoMP3?
1. Baixe o arquivo [.zip](https://github.com/Nonopichy/M4AtoMP3/raw/main/M4AtoMP3.zip) e extraia-o dentro de uma pasta. Lembre-se de que você precisa ter o Java 1.8.0 (Java 8) instalado.
2. Haverá um arquivo chamado start.bat configurado para o meu Java. Vamos configurar para o seu Java.
3. Abra a pasta `C:\Program Files\Java`. Se não existir, abra `C:\Program Files (x86)\Java`.
4. Dentro dessa pasta, você encontrará todas as versões do Java instaladas no seu computador. Os nomes dos diretórios podem conter "jre" ou "sdk" seguidos por um número. Abra a pasta que se assemelha mais a "jre-1.8" ou "sdk-1.8". Em seguida, abra a pasta "bin" e copie o caminho. (O meu deu: C:\Program Files (x86)\Java\jre-1.8\bin)
5. No arquivo start.bat, clique com o botão direito e selecione "Editar com Bloco de Notas". O conteúdo será semelhante ao seguinte:

```batch
@ECHO OFF
SET BINDIR=%~dp0
CD "%BINDIR%"
:start
"%C:\Program Files (x86)\Java\jre-1.8\bin\java.exe" -Xmx1000M -Xms1000M -jar M4AtoMP3.jar
goto start
```

6. Altere apenas o caminho do Java para o seu. Cole o caminho do Java de "C:\ até "bin\".
7. Salve o arquivo start.bat e feche.
8. Execute o start.bat. Se aparecer uma garota de anime, funcionou!

Agora basta selecionar a pasta onde estão todos os seus arquivos M4A, selecionar a pasta onde todos os arquivos MP3 serão salvos e clicar em converter. Pronto!
