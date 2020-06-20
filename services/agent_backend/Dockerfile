FROM python:3.7

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        postgresql-client \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /code/
WORKDIR /code
RUN pip install django zeep
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
