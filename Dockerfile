FROM node:22.11.0-alpine3.20

ARG USERNAME=appium
ARG DIR=/home/${USERNAME}/tests

RUN adduser --gecos ${USERNAME} --disabled-password --shell /bin/sh --uid 1014 ${USERNAME} \
    && addgroup ${USERNAME} ${USERNAME}

RUN apk add --update npm

RUN mkdir ${DIR}
COPY js /${DIR}

WORKDIR ${DIR}

RUN npm install

USER ${USERNAME}

ENV APPIUM_URL=http://host.docker.internal:4723

ENTRYPOINT ["npm", "test"]

