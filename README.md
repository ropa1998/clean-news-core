# CleanNews Core

This project provides the base classes and logic for all CleanNews projects. This is just a library that other modules will use.

Most specifically it provides all classes necessary for:
1. Scrapping trends for the last 24 hours in a Twitter region.
2. Going from scrapped titles to full articles. 
3. The engine, that combines both the trends and the article to provide a CleanNewsResult  with the trends and the articles crossed and properly organized.

## Table of contents

- [Install](#install)
- [Usage](#usage)
- [License](#license)

$##Install

This module is not designed to be installed anywhere. Yet, you will need it if you want to build other CleanNews projects.

First of all you will need to clone the project. Then you will want to build it

```$ gradle shadowJar```

This will build a jar file with all necessary dependencies, which you can find in `clean-news-core/build/libs/clean-news-core-all.jar`

###Usage

You may want to use this jar in a CleanNews project, as for example, the [clean-news-cli](https://github.com/ropa1998/clean-news-cli) app. 

In order to understand how it works please refer to the project [documentation]().   

###License

[GNU General Public License v3.0](LICENSE)