# Evaluación 2 Mingeso - Ejercicio 1

terraform {
  required_providers {
    digitalocean = {
      source = "digitalocean/digitalocean"
      version = "2.20.0"
    }
  }
}

#TF_VAR_token_do
variable "token_do" {
    type = string
    description = "Token Digital Ocean"
}

provider "digitalocean" {
  # Configuration options
  token = var.token_do
}

# Create web servers
resource "digitalocean_droplet" "server1" {
    name = "Servidor-1"
    size = "s-1vcpu-1gb"
    region = "nyc1"
    image = "ubuntu-20-04-x64"
}